import cv2
from pupil_apriltags import Detector
import numpy as np
from networktables import NetworkTables;

NetworkTables.initialize(server='roborio-3205-frc.local') #roborio address? online ppl say its team number or somthing
sd = NetworkTables.getTable('SmartDashboard')

cap = cv2.VideoCapture(0)

at_detector = Detector(
    families="tag36h11",
    nthreads=1,
    quad_decimate=1.0,
    quad_sigma=0.0,
    refine_edges=1,
    decode_sharpening=0.25,
    debug=0
)

while True:
    ret, frame = cap.read()
    if not ret:
        print("Cant capture img :(")
        break
    
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    #if want pose hafta have camera params fx, fy, cx, cy (focal lengths, optical center???)
    #how do u use checkerboard to get these tho?
    tags = at_detector.detect(gray, estimate_tag_pose=False, camera_params= None, tag_size=0.1)
    
    for tag in tags:
        (ptA, ptB, ptC, ptD) = tag.corners
        ptA = (int(ptA[0]), int(ptA[1]))
        ptB = (int(ptB[0]), int(ptB[1]))
        ptC = (int(ptC[0]), int(ptC[1]))
        ptD = (int(ptD[0]), int(ptD[1]))
        
        # BGR NOT RGB
        cv2.polylines(frame, [np.array([ptA, ptB, ptC, ptD], dtype=np.int32)], isClosed=True, color=(0, 255, 0), thickness=2)
        cv2.putText(frame, str(tag.tag_id), ptA, cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 2, cv2.LINE_AA)

        sd.putNumber('tagID', tag.tag_id)
        sd.putNumberArray('tagPose', tag.pose_t.flatten())

    cv2.imshow("frame", frame)
    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
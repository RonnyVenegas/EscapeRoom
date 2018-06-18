/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaperoom;

/**
 *
 * @author Ronny
 */
public class LockLogic {

    public LockLogic() {
    }

    public boolean unlock(int escapeRoomLevel, int riddle, int roomVariant, String strLock1, String strLock2, String strLock3, String strLock4) {
        switch (escapeRoomLevel) {
            case 1:
                switch (riddle) {
                    case 1:
                        if (roomVariant == 1) {
                            System.out.println("Level 1");
                            System.out.println("riddle 1");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 1");
                            System.out.println("riddle 1");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;

                    case 2:

                        if (roomVariant == 1) {
                            System.out.println("Level 1");
                            System.out.println("riddle 2");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 1");
                            System.out.println("riddle 2");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                    case 3:
                        if (roomVariant == 1) {
                            System.out.println("Level 1");
                            System.out.println("riddle 3");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 1");
                            System.out.println("riddle 3");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                    case 4:
                        if (roomVariant == 1) {
                            System.out.println("Level 1");
                            System.out.println("riddle 4");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 1");
                            System.out.println("riddle 4");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                }

                break;
            case 2:
                switch (riddle) {
                    case 1:
                        if (roomVariant == 1) {
                            System.out.println("Level 2");
                            System.out.println("riddle 1");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 2");
                            System.out.println("riddle 1");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;

                    case 2:

                        if (roomVariant == 1) {
                            System.out.println("Level 2");
                            System.out.println("riddle 2");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 2");
                            System.out.println("riddle 2");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                    case 3:
                        if (roomVariant == 1) {
                            System.out.println("Level 2");
                            System.out.println("riddle 3");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 2");
                            System.out.println("riddle 3");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                    case 4:
                        if (roomVariant == 1) {
                            System.out.println("Level 2");
                            System.out.println("riddle 4");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 2");
                            System.out.println("riddle 4");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                }

                break;
            case 3:
                switch (riddle) {
                    case 1:
                        if (roomVariant == 1) {
                            System.out.println("Level 3");
                            System.out.println("riddle 1");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 3");
                            System.out.println("riddle 1");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;

                    case 2:

                        if (roomVariant == 1) {
                            System.out.println("Level 3");
                            System.out.println("riddle 2");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 3");
                            System.out.println("riddle 2");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                    case 3:
                        if (roomVariant == 1) {
                            System.out.println("Level 3");
                            System.out.println("riddle 3");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 3");
                            System.out.println("riddle 3");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                    case 4:
                        if (roomVariant == 1) {
                            System.out.println("Level 3");
                            System.out.println("riddle 4");
                            System.out.println("variant 1");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }
                        } else {
                            System.out.println("Level 3");
                            System.out.println("riddle 4");
                            System.out.println("variant 2");
                            if (strLock1.equals("1") && strLock2.equals("1")
                                    && strLock3.equals("1") && strLock4.equals("1")) {
                                System.out.println("unlocked");
                                return true;
                            }

                        }
                        break;
                }

                break;
        }
        return false;
    }

}

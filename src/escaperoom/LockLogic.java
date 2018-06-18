/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaperoom;

import alerts.InformationWindow;
import com.sun.javaws.jnl.InformationDesc;
import javafx.application.Platform;
import javafx.stage.Stage;
import screenManager.Main;

/**
 *
 * @author Ronny
 */
public class LockLogic {

    public LockLogic() {
    }

    /**
     * This method is used to unlock the locks using the variables it can unlock
     * everysingle combination for a lock in the game.
     *
     * @param escapeRoomLevel
     * @param riddle
     * @param roomVariant
     * @param strLock1
     * @param strLock2
     * @param strLock3
     * @param strLock4
     * @return boolean
     */
    public boolean unlock(int escapeRoomLevel, int riddle, int roomVariant, String strLock1, String strLock2, String strLock3, String strLock4) {
        switch (escapeRoomLevel) {
            case 1:
                switch (riddle) {
                    case 1:
                        if (roomVariant == 1) {
                            System.out.println("Level 1");
                            System.out.println("riddle 1");
                            System.out.println("variant 1");
                            if (strLock1.equals("ships") && strLock2.equals("tea")
                                    && strLock3.equals("ketchup") && strLock4.equals("ring ring")) {
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
                            if (strLock1.equals("") && strLock2.equals("")
                                    && strLock3.equals("") && strLock4.equals("")) {
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
                            if (strLock1.equals("2") && strLock2.equals("4")
                                    && strLock3.equals("3") && strLock4.equals("1")) {
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
                            if (strLock1.equals("let") && strLock2.equals("me")
                                    && strLock3.equals("out") && strLock4.equals("please!")) {
                                InformationWindow.displayInformationWindow("You escaped...");
                                Platform.setImplicitExit(false);
                                Platform.exit();
                                new Main().start(new Stage());
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
    }//End of method.

}

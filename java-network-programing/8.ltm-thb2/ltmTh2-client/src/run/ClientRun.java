package run;

import controller.ClientControl;
import view.ClientView;
import view.LietKeCongNhan;
import view.ThemCongNhamFrm;
import view.TimCongNhan;

/**
 *
 * @author nddmanh
 */
public class ClientRun {
    public enum SceneName {
        MAINVIEW,
        ADDCN,
        SEARCHCN,
        LISTCN
    }
    
    public static ClientView mainView;
    public static ThemCongNhamFrm addCnView;
    public static TimCongNhan timCongNhanView;
    public static LietKeCongNhan lietKeCongNhanView;
    
    public static ClientControl clientControl;
    
    public ClientRun() {
        clientControl = new ClientControl();
        initScene();
        openScene(SceneName.MAINVIEW);
    }
    
    public void initScene() {
        mainView = new ClientView();
        addCnView = new ThemCongNhamFrm();
        timCongNhanView = new TimCongNhan();
        lietKeCongNhanView = new LietKeCongNhan();
    }

    public static void openScene(SceneName sceneName) {
        if (null != sceneName) {
            switch (sceneName) {
                case MAINVIEW:
                    mainView = new ClientView();
                    mainView.setVisible(true);
                    break;
                case ADDCN:
                    addCnView = new ThemCongNhamFrm();
                    addCnView.setVisible(true);
                    break;
                case SEARCHCN:
                    timCongNhanView = new TimCongNhan();
                    timCongNhanView.setVisible(true);
                    break;
                case LISTCN:
                    lietKeCongNhanView = new LietKeCongNhan();
                    lietKeCongNhanView.setVisible(true);
                default:
                    break;
            }
        }
    }

    public static void closeScene(SceneName sceneName) {
        if (null != sceneName) {
            switch (sceneName) {
                case MAINVIEW:
                    mainView.dispose();
                    break;
                case ADDCN:
                    addCnView.dispose();
                    break;
                case SEARCHCN:
                    timCongNhanView.dispose();
                    break;
                case LISTCN:
                    lietKeCongNhanView.dispose();
                    
                default:
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        new ClientRun();
    }
}

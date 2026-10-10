import gui.AppSkeleton;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppSkeleton app = new AppSkeleton();
            app.setVisible(true);
        });
    }
}

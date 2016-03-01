
public class Test {

    public static void main(String[] args) {
        JFrameAL platformLocated = new JFrameAL("Platform-located Frame", JFrameAL.PLATFORM);
        JFrameAL centered = new JFrameAL("Centered frame", JFrameAL.CENTER);
        platformLocated.setVisible(true);
        centered.setVisible(true);
    }
}

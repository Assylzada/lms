import java.util.HashMap;
import java.util.Map;

class ProgressTracker {
    private final Map<String, Integer> progressMap = new HashMap<>();

    public void updateProgress(String key, int percent) {
        progressMap.put(key, Math.min(percent, 100));
    }

    public int getProgress(String key) {
        return progressMap.getOrDefault(key, 0);
    }

    public void showProgress(String studentName, String courseName) {
        String key = studentName + "-" + courseName;
        System.out.println("📈 " + studentName + " progress in " + courseName + ": " + getProgress(key) + "%");
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Epic;
import ru.netology.domain.Meeting;
import ru.netology.domain.SimpleTask;
import ru.netology.domain.Task;

public class TasksTest {

    @Test
    public void simpleTaskMatchesTrue() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertTrue(task.matches("родителям"));
    }

    @Test
    public void simpleTaskMatchesFalse() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertFalse(task.matches("молоко"));
    }

    @Test
    public void epicMatchesTrue() {
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Assertions.assertTrue(epic.matches("Яйца"));
    }

    @Test
    public void epicMatchesFalse() {
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Assertions.assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void epicMatchesEmptySubtasks() {
        Epic epic = new Epic(2, new String[]{});
        Assertions.assertFalse(epic.matches("Молоко")); // цикл не выполнится ни разу
    }

    @Test
    public void meetingMatchesByTopic() {
        Meeting meeting = new Meeting(3, "Выкатка", "Проект", "Время");
        Assertions.assertTrue(meeting.matches("Выкатка"));
    }

    @Test
    public void meetingMatchesByProject() {
        Meeting meeting = new Meeting(3, "Выкатка", "Проект", "Время");
        Assertions.assertTrue(meeting.matches("Проект"));
    }

    @Test
    public void meetingMatchesFalse() {
        Meeting meeting = new Meeting(3, "Выкатка", "Проект", "Время");
        Assertions.assertFalse(meeting.matches("Время"));
    }

    @Test
    public void taskEqualsCoverage() {
        Task task1 = new SimpleTask(1, "A");
        Task task2 = new SimpleTask(1, "A");
        Task task3 = new SimpleTask(2, "B");
        Meeting meeting = new Meeting(1, "T", "P", "S");

        Assertions.assertTrue(task1.equals(task1));

        Assertions.assertFalse(task1.equals(null));

        Assertions.assertFalse(task1.equals(meeting));

        Assertions.assertFalse(task1.equals(task3));

        Assertions.assertTrue(task1.equals(task2));
    }
}
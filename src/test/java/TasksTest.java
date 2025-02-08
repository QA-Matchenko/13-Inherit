import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
    @Test
    public void testSimpleTasksMatchesOk() {
        SimpleTask task= new SimpleTask(36546242, "Позвонить родителям");

        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testSimpleTaskMatchesFailed() {
        SimpleTask task= new SimpleTask(36546242, "Позвонить родителям");
        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);

    }
    @Test
    public void testEpicMatchesOk() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testEpicMatchesFailed() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Йогурт");

        Assertions.assertFalse(actual);
    }
    @Test
    public void testMeetingMatchesOk() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Во вторник");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testMeetingMatchesOk1() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testMeetingMatchesFalse() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Среда");

        Assertions.assertFalse(actual);
    }

}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");


        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Трусы", "Носки", "Паспорт"};
        Epic epic = new Epic(12, subtasks);

        boolean actual = epic.matches("Носки");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Трусы", "Носки", "Паспорт"};
        Epic epic = new Epic(12, subtasks);

        boolean actual = epic.matches("Пельмени");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(41, "Массаж", "Выжить до конца года", "Суббота утро");

        boolean actual = meeting.matches("Массаж");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingProjectMatches() {
        Meeting meeting = new Meeting(41, "Массаж", "Выжить до конца года", "Суббота утро");

        boolean actual = meeting.matches("Выжить до конца года");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNotMatches() {
        Meeting meeting = new Meeting(41, "Массаж", "Выжить до конца года", "Суббота утро");

        boolean actual = meeting.matches("Суббота утро");

        Assertions.assertFalse(actual);
    }
}
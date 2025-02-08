public class Todos {

    private Tasks[] tasks = new Tasks[0]; // <- тут будут все задачи

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     * @param current Массив, в который мы хотим добавить элемент
     * @param task Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Tasks[] addToArray(Tasks[] current, Tasks task) {
        Tasks[] tmp = new Tasks[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    /**
     * Метод добавления задачи в список дел
     * @param task Добавляемая задач
     */
    public void add(Tasks task) { // <- вот здесь в параметре может лежать объект и вида SimpleTask, и вида Epic, и вида Meeting
        tasks = addToArray(tasks, task);
    }

    public Tasks[] findAll() {
        return tasks;
    }
    /**
     * Метод поиска задач, которые подходят под поисковый запрос
     * @param query Поисковый запрос
     * @return Массив из подошедших задач
     */
    public Tasks[] search(String query) {
        Tasks[] result = new Tasks[0]; // массив для ответа
        for (Tasks task : tasks) { // перебираем все задачи
            if (task.matches(query)) { // если задача подходит под запрос
                result = addToArray(result, task); // добавляем её в массив ответа
            }
        }
        return result;
    }
}

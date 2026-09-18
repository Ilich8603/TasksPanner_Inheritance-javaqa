package ru.netology.domain;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks.clone();

    }


    public String[] getSubtasks() {
        return subtasks.clone();
    }


    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {

    private final List<TodoListItem> list = new ArrayList<>();

    /*
     * Add a new item to the list, given a description and priority.
     */
    public void addItem(String description, int priority) {
       list.add(new TodoListItem(description, priority));
    }
    
    /*
     * Get the item at a given index.
     */
    public TodoListItem getItem(int i) {
        return list.get(i);
    }
    
    /*
     * Get the number of items in the list.
     */
    public int size() {
       return list.size();
    }
    
    /*
     * Find the first item in the list which is not marked "done".
     * If all items are marked "done", this method returns null.
     */
    public TodoListItem findFirstNotDone() {
        for (TodoListItem item : list) {
            if (item.isIncomplete()) {
                return item;
            }
        }
        return null;
   //     return list.stream().filter(item -> !item.isDone()).findFirst().orElse(null);
    }
    
    /*
     * Find the highest-priority item which is not marked "done".
     * If all items are marked "done", this method returns null.
     */
    public TodoListItem findHighestPriorityNotDone() {
        if (list.isEmpty()) {
            return null;
        }
        TodoListItem currentHighest = list.get(0);
        boolean allDone = true;
        for (TodoListItem item : list) {
            if (item.isDone()) {
                continue;
            }
            allDone = false;
            if (item.getPriority() > currentHighest.getPriority()) {
                currentHighest = item;
            }
        }
        if (allDone) {
            return null;
        }
        return currentHighest;
        /*
        return list.stream()
                .filter(item -> !item.isDone())
                .sorted(Comparator.comparingInt(TodoListItem::getPriority).reversed())
                .findFirst().orElse(null);*/
    }
    
    /*
     * Search for items whose description contains the given text.
     * The descriptions are returned in a list.
     */
    public List<String> search(String text) {
      /*  return list.stream()
                .map(TodoListItem::getDescription)
                .filter(description -> description.contains(text))
                .collect(Collectors.toList());*/

      List<String> descriptions = new ArrayList<>();
        for (TodoListItem item : list) {
            String description = item.getDescription();
            if (description.contains(text)) {
                descriptions.add(description);
            }
        }
        return descriptions;
    }
}

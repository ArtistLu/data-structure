public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.push(2);
        System.out.println(stack);


        for (int i = 0; i < 10; i++) {
            System.out.println(stack.peek());
            stack.pop();

            System.out.println(stack);
        }


    }
}

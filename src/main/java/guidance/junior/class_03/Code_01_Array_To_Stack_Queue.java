package guidance.junior.class_03;

public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = obj;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int temp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[temp];
        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ArrayStack stack = new ArrayStack(arr.length);
        ArrayQueue queue = new ArrayQueue(arr.length);
        for (int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+" ");
            stack.push(arr[i]);
            queue.push(arr[i]);
        }
        System.out.println();

        for (int i = 0 ;i < arr.length;i++){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();

        for (int i = 0 ;i < arr.length;i++){
            System.out.print(queue.poll()+" ");
        }
        System.out.println();
    }


}

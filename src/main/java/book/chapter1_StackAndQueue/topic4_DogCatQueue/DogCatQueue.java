package book.chapter1_StackAndQueue.topic4_DogCatQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (catQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (dogQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty");
        }
    }

    public Dog pollDog() {
        if (dogQ.isEmpty()) {
            throw new RuntimeException("err, dogQ is empty");
        } else {
            return (Dog) dogQ.poll().getPet();
        }
    }

    public Cat pollCat() {
        if (catQ.isEmpty()) {
            throw new RuntimeException("err, catQ is empty");
        } else {
            return (Cat) catQ.poll().getPet();
        }
    }

    public boolean isEmpty(){
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }
}

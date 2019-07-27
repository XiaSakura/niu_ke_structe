package com.xia.structe.class03;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 */
@Data
public class DogCatQueue {
    private Queue<PetEnter> dogQueue;
    private Queue<PetEnter> catQueue;
    private Long count;//为了传递给PetEnter里面的计数器

    public DogCatQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = Long.valueOf(0);
    }

    public void add(Pet pet) {
        //如果该pet类型是猫
        if (pet.getType().equals("cat")) {
            //加入猫队列中
            this.catQueue.add(new PetEnter(pet, this.count++));
        } else if (pet.getType().equals("dog")) {
            this.dogQueue.add(new PetEnter(pet, this.count++));
        } else {
            throw new RuntimeException("既不是猫又不是狗");
        }
    }

    /**
     * 将队列中的所有实例 按照进队列的先后顺序依次弹出
     * 我们这个根据count的大小
     *
     * @return
     */
    public Pet pollAll() {
        //二者都不为空时
        if (!isDogEmpty()&&!isCatEmpty()) {
            if (this.dogQueue.peek().getCount()>this.catQueue.peek().getCount()) {
                return this.catQueue.poll().getPet();
            }else {
                return this.dogQueue.poll().getPet();
            }
        }
        //如果dog为空时
        if (isDogEmpty()) {
            return this.catQueue.poll().getPet();
        }else if (isCatEmpty()){
            return this.dogQueue.poll().getPet();
        }else{
            throw new RuntimeException("队列已经空了");
        }
    }

    public Dog pollDog(){
        if (!isDogEmpty()){
            return (Dog) this.dogQueue.poll().getPet();
        }else{
            throw new RuntimeException("狗队列已经空了");
        }
    }

    public Cat pollCat(){
        if (!isCatEmpty()){
            return (Cat) this.catQueue.poll().getPet();
        }else{
            throw new RuntimeException("猫队列已经空了");
        }
    }

    /**
     * 判断该队列是否有dog或者cat的实例
     *
     * @return
     */
    public boolean isEmpty() {
        if (this.dogQueue.isEmpty() && this.catQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
//        while (!test.isDogEmpty()) {
//            System.out.println(test.pollDog().getType());
//        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getType());
        }
    }
}

class Pet {
    private String type;

    public String getType() {
        return type;
    }


    public Pet(String type) {
        this.type = type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}

class PetEnter {
    private Pet pet;
    private Long count;

    public PetEnter(Pet pet, Long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

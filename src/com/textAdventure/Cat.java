package com.textAdventure;

import com.utility.SuperObject;

public class Cat {

        public int health;
        public SuperObject currentInventory;

        public String Name;
        //user input?


        public int getHealth() {
                return health;
        }

        public void setHealth(int health) {
                this.health = health;
        }

        public SuperObject getCurrentInventory() {
                return currentInventory;
        }

        public void setCurrentInventory(SuperObject currentInventory) {
                this.currentInventory = currentInventory;
        }

        public String getName() {
                return Name;
        }

        public void setName(String name) {
                Name = name;
        }

        @Override
        public String toString() {
                return "Cat{" +
                        "health=" + health +
                        ", currentInventory=" + currentInventory +
                        ", Name='" + Name + '\'' +
                        '}';
        }
}

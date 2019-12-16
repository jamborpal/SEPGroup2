package model;

import java.util.ArrayList;

public class ClassList
{
    private ArrayList<Class> classes; //creating an ArrayListOfClasses

    public ClassList() //initializing classes
    {
        this.classes = new ArrayList<>();
    }

    public Class getClass(int index)
    {
        return classes.get(index);
    }

    public int size()
    {
        return classes.size();
    }
    public Class getClassWithRoom(Room room){
        for(int i=0;i<classes.size();i++){
            if(classes.get(i).getClassRoom().equals(room.getRoomName())){
                return classes.get(i);
            }
        }return null;
    }

    public ArrayList<Class> getAllClasses()
    {
        ArrayList<Class> allClassesNames = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++)
        {
            allClassesNames.add(classes.get(i));
        }
        return allClassesNames;
    }

    public Class getClass(String className)//getting a class by its name
    {
        for (int i = 0; i < classes.size(); i++)
        {
            if (classes.get(i).getClassName().equals(className))
            {
                return classes.get(i);
            }
        }
        return null;
    }

    public void add(Class theClass)
    {
        classes.add(theClass);
    }

    public String toString() //returning a String with all of the information of all the classes
    {
        String s = "";
        for (int i = 0; i < classes.size(); i++)
        {
            s += classes.get(i).toString();
            s += "\n";
        }
        return s;
    }
}

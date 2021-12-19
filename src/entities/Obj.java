package entities;

import java.util.Objects;

public class Obj extends ObjTree<Obj>{

    Integer myValue;

    public Obj(Integer myValue){
        this.myValue = myValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obj obj = (Obj) o;
        return Objects.equals(myValue, obj.myValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myValue);
    }

    @Override
    public int compare(Obj other) {
        return 0;
    }

    @Override
    public String toString() {
        return myValue.toString();
    }

    @Override
    public int compareTo(Obj other) {
        int i = 0;

        if (this.myValue > other.myValue){
            i = 1;
        }else if(this.myValue < other.myValue){
            i = -1;
        }
        return i;
    }
}

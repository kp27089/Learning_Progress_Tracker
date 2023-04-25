package tracker;

import java.util.Comparator;

public class ContentComparator implements Comparator<Subject> {



    @Override
    public int compare(Subject o1, Subject o2) {
        Double object1 = Double.valueOf(o1.getSubject());
        Double object2 = Double.valueOf(o2.getSubject());

        if (object1.equals(object2)) {

            return String.valueOf(o1.getId()).compareTo(String.valueOf(o2.getId()));


        }else{
            return Double.compare(object2, object1);
        }


    }
    }
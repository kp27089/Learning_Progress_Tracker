package tracker;

import javax.swing.*;
import java.util.*;

public class StatisticCommand implements Command{

    Map<String, Integer> subjectCount = new HashMap<>();
    Map<String, Integer> gradesCount = new HashMap<>();
    Map<String, Student> popularity = new HashMap<>();

    List<Subject> grades = new ArrayList<>();
    int totalStudents = 0;
    Scanner scanner = new Scanner(System.in);
    String subjectName;


    @Override
    public void execute() {
        getSubjectsGrades();

        int counter = LearningProgressTracker.getStudentsList().size();

        System.out.println("Type the name of a course to see details or 'back' to quit:");
        System.out.println("Most popular: "+(subjectCount.size()!=0?getMaxMinVal(Collections.max(subjectCount.values())):"n/a"));
        System.out.println("Least popular: "+ (subjectCount.size()!=0?Collections.min(subjectCount.values())==Collections.max(subjectCount.values())?"n/a":getMaxMinVal(Collections.min(subjectCount.values())):"n/a"));
    //    System.out.println("Highest activity: "+ (subjectCount.size()!=0?Collections.max(gradesCount.values()):"n/a"));
        System.out.println("Highest activity: "+ (subjectCount.size()!=0?getMaxMinVal(Collections.max(subjectCount.values())):"n/a"));
      //  System.out.println("Lowest activity: "+ (subjectCount.size()!=0?Collections.min(gradesCount.values()):"n/a"));
        System.out.println("Lowest activity: "+ (subjectCount.size()!=0?Collections.min(subjectCount.values())==Collections.max(subjectCount.values())?"n/a":getMaxMinVal(Collections.min(subjectCount.values())):"n/a"));
        System.out.println("Easiest course: "+ (subjectCount.size()!=0?getMHighLow(Collections.max(gradesCount.values())):"n/a"));
   //    System.out.println("Easiest course: "+ (subjectCount.size()!=0?Collections.max(gradesCount.values())/subjectCount.size():"n/a"));
   //   System.out.println("Hardest course: "+ (subjectCount.size()!=0?Collections.min(gradesCount.values())/subjectCount.size():"n/a"));
        System.out.println("Hardest course: "+ (subjectCount.size()!=0?getMHighLow(Collections.min(gradesCount.values())):"n/a"));

        while (true) {

            subjectName = scanner.nextLine().toLowerCase();

            if (subjectName.equals("back")) {
                break;
            }

            if(subjectName.equals("java")||subjectName.equals("dsa")||subjectName.equals("databases")||subjectName.equals("spring")){
                System.out.println(subjectName.substring(0,1).toUpperCase()+subjectName.substring(1));
                System.out.println("id    points    completed");
                if(subjectName.equals("java")){
                    grades.clear();
                    popularity = LearningProgressTracker.getStudentsList();
                    for(Map.Entry<String, Student> map : popularity.entrySet()){

                    grades.add(new Subject(map.getValue().java, Integer.valueOf(map.getKey())));
                    }
                    grades.sort(new ContentComparator());
                   for (Subject k : grades){
                       if(k.getSubject().equals("0")){

                       }else
                       System.out.println(k.getId()+" "+k.getSubject()+"           "+String.format("%.1f", ((Float.valueOf(k.getSubject())/600)*100.0))+"%");

                   }


                }else if(subjectName.equals("dsa")){
                    grades.clear();
                    popularity = LearningProgressTracker.getStudentsList();
                    for(Map.Entry<String, Student> map : popularity.entrySet()){

                        grades.add(new Subject(map.getValue().dsa, Integer.valueOf(map.getKey())));
                    }
                    grades.sort(new ContentComparator());
                    for (Subject k : grades){
                        if(k.getSubject().equals("0")){

                        }else
                        System.out.println(k.getId()+" "+k.getSubject()+"           "+String.format("%.1f", ((Float.valueOf(k.getSubject())/400)*100.0))+"%");

                    }

                }else if(subjectName.equals("databases")){
                    grades.clear();
                    popularity = LearningProgressTracker.getStudentsList();
                    for(Map.Entry<String, Student> map : popularity.entrySet()){

                        grades.add(new Subject(map.getValue().databases, Integer.valueOf(map.getKey())));
                    }
                    grades.sort(new ContentComparator());
                    for (Subject k : grades){
                        if(k.getSubject().equals("0")){

                        }else
                        System.out.println(k.getId()+" "+k.getSubject()+"           "+String.format("%.1f", ((Float.valueOf(k.getSubject())/480)*100.0))+"%");

                    }
                }else if(subjectName.equals("spring")){
                    grades.clear();
                    popularity = LearningProgressTracker.getStudentsList();
                    for(Map.Entry<String, Student> map : popularity.entrySet()){

                        grades.add(new Subject(map.getValue().spring, Integer.valueOf(map.getKey())));
                    }
                    grades.sort(new ContentComparator());
                    for (Subject k : grades){
                        if(k.getSubject().equals("0")){

                        }else
                        System.out.println(k.getId()+" "+k.getSubject()+"           "+String.format("%.1f", ((Float.valueOf(k.getSubject())/550)*100.0))+"%");

                    }
                }

            }else{
                System.out.println("Unknown course.");
            }


        }

    }

    private void getSubjectsGrades(){
        LearningProgressTracker.getStudentsList().forEach((k,v)->{
            int total = 0;
          //  for(Map.Entry<String, Student> sc: LearningProgressTracker.getStudentsList().entrySet()){
            String tempKey;



            subjectCount.putIfAbsent("Java",0);
            gradesCount.putIfAbsent("Java",0);
            subjectCount.putIfAbsent("DSA",0);
           gradesCount.putIfAbsent("DSA",0);
            subjectCount.putIfAbsent("Databases",0);
            gradesCount.putIfAbsent("Databases",0);
            subjectCount.putIfAbsent("Spring",0);
            gradesCount.putIfAbsent("Spring",0);
                if(!LearningProgressTracker.getStudentsList().get(k).java.equals(0)){

                    subjectCount.put("Java",subjectCount.get("Java")+1);
                    gradesCount.put("Java",gradesCount.get("Java")+Integer.valueOf(LearningProgressTracker.getStudentsList().get(k).java));
                  //  gradesCount.put("Java",subjectCount.getOrDefault("Java",0)+Integer.parseInt(String.valueOf(LearningProgressTracker.getStudentsList().get(k))));

                }

//               if(sc.getValue().getJava().charAt(0)>0){
//
//                   subjectCount.putIfAbsent("Java",0);
//                   subjectCount.put("Java",subjectCount.get("Java")+1);
//                   // subjectCount.put("Java",subjectCount.put()
//                   gradesCount.put("Java",subjectCount.getOrDefault("Java",0)+Integer.parseInt(String.valueOf(sc.getValue().getJava())));
//                };
               if(!LearningProgressTracker.getStudentsList().get(k).dsa.equals(0)){
                   subjectCount.put("DSA",subjectCount.getOrDefault("DSA",0)+1);
                   gradesCount.put("DSA",gradesCount.get("DSA")+Integer.valueOf(LearningProgressTracker.getStudentsList().get(k).dsa));
            //    gradesCount.put("DSA",subjectCount.getOrDefault("DSA",0)+Integer.parseInt(String.valueOf(LearningProgressTracker.getStudentsList().get(k))));
               }
                if(!LearningProgressTracker.getStudentsList().get(k).spring.equals(0)){
                    subjectCount.put("Spring",subjectCount.getOrDefault("Spring",0)+1);
                    gradesCount.put("Spring",gradesCount.get("Spring")+Integer.valueOf(LearningProgressTracker.getStudentsList().get(k).spring));
                //    gradesCount.put("Spring",subjectCount.getOrDefault("Spring",0)+Integer.parseInt(String.valueOf(LearningProgressTracker.getStudentsList().get(k))));
                }
                if(!LearningProgressTracker.getStudentsList().get(k).databases.equals(0)){
                    subjectCount.put("Databases",subjectCount.getOrDefault("Databases",0)+1);
                    gradesCount.put("Databases",gradesCount.get("Databases")+Integer.valueOf(LearningProgressTracker.getStudentsList().get(k).databases));
                 //   gradesCount.put("Databases",subjectCount.getOrDefault("Databases",0)+Integer.parseInt(String.valueOf(LearningProgressTracker.getStudentsList().get(k))));
                }


        });
    }

    private String getMaxMinVal(int key){
        String result ="";
        for (Map.Entry<String, Integer> entry:subjectCount.entrySet()){
            if(entry.getValue()==key){
                result=result+entry.getKey()+" ";
            }
        }

        return result.trim();
    };

    private String getMHighLow(int key){
        String result ="";
        for (Map.Entry<String, Integer> entry:gradesCount.entrySet()){
            if(entry.getValue()==key){
                result=result+entry.getKey()+" ";
            }
        }

        return result.trim();
    };



}

import br.com.dio.bootcamp.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.setTitle("Java course");
        course.setDescription("Description java course");
        course.setWorkload(8);

        Course course1 = new Course();
        course1.setTitle("JS course");
        course1.setDescription("Description js course");
        course1.setWorkload(4);


        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java mentoring");
        mentoring.setDescription("description java mentoring");
        mentoring.setDate(LocalDate.now());

//        System.out.println(course);
//        System.out.println(course1);
//        System.out.println(mentoring);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Bootcamp 1");
        bootcamp.setDescription("Bootcamp description");
        bootcamp.getContents().add(course);
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(mentoring);

        Dev dev1 = new Dev();
        dev1.setName("Dev 1");
        dev1.registerBootcamp(bootcamp);
        System.out.println("Conteudos inscritos dev1 " + dev1.getInscribedContents());
        dev1.toProgress();
        dev1.toProgress();
        System.out.println("Conteudos inscritos dev1 " + dev1.getInscribedContents());
        System.out.println("Conteudos concluidos dev1 " + dev1.getCompletedContents());
        System.out.println("XP: " + dev1.calculateTotalXp());

        System.out.println();
        System.out.println();

        Dev dev2 = new Dev();
        dev1.setName("Dev 2");
        dev2.registerBootcamp(bootcamp);
        System.out.println("Conteudos inscritos dev2" + dev2.getInscribedContents());
        dev2.toProgress();
        System.out.println("Conteudos inscritos dev2" + dev2.getInscribedContents());
        System.out.println("Conteudos concluidos dev2 " + dev2.getCompletedContents());
        System.out.println("XP: " + dev2.calculateTotalXp());
    }
}

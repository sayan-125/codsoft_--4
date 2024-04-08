import java.util.*;
class Quizquestion {
    String question;
    List<String> options;
    int correctoption;
    public Quizquestion(String question, List<String> options, int correctoption) {
        this.question = question;
        this.options = options;
        this.correctoption = correctoption;
    }
    public String getquestion() {
        return question;
    }
    public List<String> getoptions() {
        return options;
    }
    public int getcorrectoption() {
        return correctoption;
    }
}
class application {
    static List<Quizquestion> questions = new ArrayList<>();
    static int score = 0;
    public static void main(String[] args) {
        questions();
        startquiz();
    }
    static void questions() {
        List<String> options1 = Arrays.asList("1: Guido van Rossum", "2: James Gosling", "3: Dennis Ritchie", "4: Bjarne Stroustrup");
        Quizquestion question1 = new Quizquestion("Who invented Java Programming?", options1, 2);
        List<String> options2 = Arrays.asList("1: Java is a sequence-dependent programming language", "2: Java is a code dependent programming language", "3: Java is a platform-dependent programming language", "4: Java is a platform-independent programming language");
        Quizquestion question2 = new Quizquestion("Which statement is true about Java?", options2, 4);
        List<String> options3 = Arrays.asList("1: JRE", "2: JIT", "3: JDK", "4: JVM");
        Quizquestion question3 = new Quizquestion("Which component is used to compile, debug and execute the java programs?", options3, 3);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }
    static void startquiz() {
        Scanner scanner = new Scanner(System.in);
        for (Quizquestion question : questions) {
            System.out.println(question.getquestion());
            for (String option : question.getoptions()) {
                System.out.println(option);
            }
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    timer.cancel();
                    System.exit(0);
                }
            };
            timer.schedule(task, 10000);
            int selectoption = scanner.nextInt();
            timer.cancel(); 
            if (selectoption == question.getcorrectoption()) {
                System.out.println("Correct answer.");
                score++;
            } else if (selectoption != 1 || selectoption != 2 || selectoption != 3 || selectoption != 4  ) {
                System.out.println("Invalid answer.");
            }
            else {
                System.out.println("Incorrect answer.");
            }
        }
        scanner.close();
        System.out.println("\nResult : ");
        System.out.println("---------------------------------------------------");
        System.out.println("Your score is: " + score + "/" + questions.size());
    }
}

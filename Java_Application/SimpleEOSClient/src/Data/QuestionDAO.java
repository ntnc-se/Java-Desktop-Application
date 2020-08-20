/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import model.Answer;
import model.Question;

/**
 *
 * @author sonnt
 */
public class QuestionDAO {
    public ArrayList<Question> getQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();
        int count = 0;
        Question q1 = new Question();
        q1.setId(1);
        q1.setContent("The World Wide Web was devised by ______.");
        Answer q1_a1 = new Answer();
        q1_a1.setContent("a. CERN");
        q1_a1.setCorrect(true);
        q1.getAnswers().add(q1_a1);
        Answer q1_a2 = new Answer();
        q1_a2.setContent("b. ECRN");
        q1_a2.setCorrect(false);
        q1.getAnswers().add(q1_a2);
        Answer q1_a3 = new Answer();
        q1_a3.setContent("c. CARN");
        q1_a3.setCorrect(false);
        q1.getAnswers().add(q1_a3);
        Answer q1_a4 = new Answer();
        q1_a4.setContent("d. NET");
        q1_a4.setCorrect(false);
        q1.getAnswers().add(q1_a4);
        questions.add(q1);
        
        Question q2 = new Question();
        q2.setId(2);
        q2.setContent("A _____ is a language for defining data structures");
        Answer q2_a1 = new Answer();
        q2_a1.setContent("a. DDL");
        q2_a1.setCorrect(true);
        q2.getAnswers().add(q2_a1);
        Answer q2_a2 = new Answer();
        q2_a2.setContent("b. DML");
        q2_a2.setCorrect(false);
        q2.getAnswers().add(q2_a2);
        Answer q2_a3 = new Answer();
        q2_a3.setContent("c. DCL");
        q2_a3.setCorrect(false);
        q2.getAnswers().add(q2_a3);
        Answer q2_a4 = new Answer();
        q2_a4.setContent("d. None of the others");
        q2_a4.setCorrect(false);
        q2.getAnswers().add(q2_a4);
        questions.add(q2);
        
        Question q3 = new Question();
        q3.setId(3);
        q3.setContent("Which statement is used to remove a relation named R?");
        Answer q3_a1 = new Answer();
        q3_a1.setContent("a. DROP TABLE R;");
        q3_a1.setCorrect(true);
        q3.getAnswers().add(q3_a1);
        Answer q3_a2 = new Answer();
        q3_a2.setContent("b. REMOVE TABLE R;");
        q3_a2.setCorrect(false);
        q3.getAnswers().add(q3_a2);
        Answer q3_a3 = new Answer();
        q3_a3.setContent("c. DELETE TABLE R;");
        q3_a3.setCorrect(false);
        q3.getAnswers().add(q3_a3);
        Answer q3_a4 = new Answer();
        q3_a4.setContent("d. TRUNCATE TABLE R;");
        q3_a4.setCorrect(false);
        q3.getAnswers().add(q3_a4);
        questions.add(q3);
        
        Question q4 = new Question();
        q4.setId(4);
        q4.setContent("The key for a weak entity set E is ...");
        Answer q4_a1 = new Answer();
        q4_a1.setContent("a. Zero or more attributes of E");
        q4_a1.setCorrect(false);
        q4.getAnswers().add(q4_a1);
        Answer q4_a2 = new Answer();
        q4_a2.setContent("b. The set of attributes of supporting relationships for E");
        q4_a2.setCorrect(false);
        q4.getAnswers().add(q4_a2);
        Answer q4_a3 = new Answer();
        q4_a3.setContent("c. The set of attributes of supporting entity sets");
        q4_a3.setCorrect(false);
        q4.getAnswers().add(q4_a3);
        Answer q4_a4 = new Answer();
        q4_a4.setContent("d. Zero or more attributes of E and key attributes from"
                + " supporting entity sets");
        q4_a4.setCorrect(true);
        q4.getAnswers().add(q4_a4);
        questions.add(q4);
        
        Question q5 = new Question();
        q5.setId(5);
        q5.setContent("Web pages contain______to other web pages.");
        Answer q5_a1 = new Answer();
        q5_a1.setContent("a. connections");
        q5_a1.setCorrect(false);
        q5.getAnswers().add(q5_a1);
        Answer q5_a2 = new Answer();
        q5_a2.setContent("b. relation");
        q5_a2.setCorrect(false);
        q5.getAnswers().add(q5_a2);
        Answer q5_a3 = new Answer();
        q5_a3.setContent("c. hyperlinks");
        q5_a3.setCorrect(true);
        q5.getAnswers().add(q5_a3);
        Answer q5_a4 = new Answer();
        q5_a4.setContent("d. none of the above");
        q5_a4.setCorrect(false);
        q5.getAnswers().add(q5_a4);
        questions.add(q5);
        
        Question q6 = new Question();
        q6.setId(6);
        q6.setContent("For internal memory, the ___is equal to the number "
                + "of electrical lines into and out of the memory module.");
        Answer q6_a1 = new Answer();
        q6_a1.setContent("a. Access time");
        q6_a1.setCorrect(false);
        q6.getAnswers().add(q6_a1);
        Answer q6_a2 = new Answer();
        q6_a2.setContent("b. Unit of transfer");
        q6_a2.setCorrect(true);
        q6.getAnswers().add(q6_a2);
        Answer q6_a3 = new Answer();
        q6_a3.setContent("c. Capacity");
        q6_a3.setCorrect(false);
        q6.getAnswers().add(q6_a3);
        Answer q6_a4 = new Answer();
        q6_a4.setContent("d. Memory ratio");
        q6_a4.setCorrect(false);
        q6.getAnswers().add(q6_a4);
        questions.add(q6);
        
        Question q7 = new Question();
        q7.setId(7);
        q7.setContent("Which of the following signatures are valid for the "
                + "main() method entry point of an application?\n" +
                "(Choose all that apply.)");
        Answer q7_a1 = new Answer();
        q7_a1.setContent("a. public static void main()");
        q7_a1.setCorrect(false);
        q7.getAnswers().add(q7_a1);
        Answer q7_a2 = new Answer();
        q7_a2.setContent("b. public static void main(String arg[])");
        q7_a2.setCorrect(true);
        q7.getAnswers().add(q7_a2);
        Answer q7_a3 = new Answer();
        q7_a3.setContent("c. public void main(String [] arg)");
        q7_a3.setCorrect(true);
        q7.getAnswers().add(q7_a3);
        Answer q7_a4 = new Answer();
        q7_a4.setContent("d. public static void main(String[] args)");
        q7_a4.setCorrect(false);
        q7.getAnswers().add(q7_a4);
        questions.add(q7);
        
        Question q8 = new Question();
        q8.setId(8);
        q8.setContent("Which class provides locale-sensitive text formatting for"
                + " date and time information?");
        Answer q8_a1 = new Answer();
        q8_a1.setContent("a. java.util.TimeFormat");
        q8_a1.setCorrect(false);
        q8.getAnswers().add(q8_a1);
        Answer q8_a2 = new Answer();
        q8_a2.setContent("b. java.util.DateFormat");
        q8_a2.setCorrect(false);
        q8.getAnswers().add(q8_a2);
        Answer q8_a3 = new Answer();
        q8_a3.setContent("c. java.text.TimeFormat");
        q8_a3.setCorrect(false);
        q8.getAnswers().add(q8_a3);
        Answer q8_a4 = new Answer();
        q8_a4.setContent("d. java.text.DateFormat");
        q8_a4.setCorrect(true);
        q8.getAnswers().add(q8_a4);
        questions.add(q8);
        
        Question q9 = new Question();
        q9.setId(9);
        q9.setContent("Which of the following code snippets compile?");
        Answer q9_a1 = new Answer();
        q9_a1.setContent("a. Integer i = 7;");
        q9_a1.setCorrect(true);
        q9.getAnswers().add(q9_a1);
        Answer q9_a2 = new Answer();
        q9_a2.setContent("b. Integer i = new Integer(5); int j = i;");
        q9_a2.setCorrect(true);
        q9.getAnswers().add(q9_a2);
        Answer q9_a3 = new Answer();
        q9_a3.setContent("c. byte b = 7;");
        q9_a3.setCorrect(true);
        q9.getAnswers().add(q9_a3);
        Answer q9_a4 = new Answer();
        q9_a4.setContent("d. int i = 7; byte b = i;");
        q9_a4.setCorrect(false);
        q9.getAnswers().add(q9_a4);
        questions.add(q9);
        
        Question q10 = new Question();
        q10.setId(10);
        q10.setContent("How many bits does a float contain?");
        Answer q10_a1 = new Answer();
        q10_a1.setContent("a. 1");
        q10_a1.setCorrect(true);
        q10.getAnswers().add(q10_a1);
        Answer q10_a2 = new Answer();
        q10_a2.setContent("b. 8");
        q10_a2.setCorrect(false);
        q10.getAnswers().add(q10_a2);
        Answer q10_a3 = new Answer();
        q10_a3.setContent("c. 16");
        q10_a3.setCorrect(false);
        q10.getAnswers().add(q10_a3);
        Answer q10_a4 = new Answer();
        q10_a4.setContent("d. 32");
        q10_a4.setCorrect(false);
        q10.getAnswers().add(q10_a4);
        questions.add(q10);

        return questions;
    }
}

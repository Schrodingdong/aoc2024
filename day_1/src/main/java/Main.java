import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

  public static int calculateDistance(List<Integer> l, List<Integer> r) {
      l.sort((a, b) -> a - b);
      r.sort((a, b) -> a - b);
      int distance = 0;
      for (int i = 0; i < l.size(); i ++){
        distance += Math.abs(l.get(i) - r.get(i));
      }
      return distance;
  }

  public static int calculateSimilarityScore(List<Integer> l, List<Integer> r) {
      int similarityScore = 0;
      for (int i : l) {
        for (int j : r) {
          if (i == j) similarityScore += i;
        }
      }
      return similarityScore;
  }

  public static void main(String[] args) {
    try {
      // Read the input
      String pathToFile = "input.txt";
      File f = new File(pathToFile);
      Scanner s = new Scanner(f);
      List<Integer> leftList = new ArrayList<>();
      List<Integer> rightList = new ArrayList<>();
      while (s.hasNextLine()) {
        String line = s.nextLine();
        String[] splitLine = line.split("\s+");
        int left = Integer.parseInt(splitLine[0]);
        int right = Integer.parseInt(splitLine[1]);
        leftList.add(left);
        rightList.add(right);
      }
      s.close();

      // part 1 -- Distance between lists
      int distance = calculateDistance(leftList, rightList);
      System.out.println("Distance between lists: " + distance);

      // part 2 -- Similarity score
      int similarityScore = calculateSimilarityScore(leftList, rightList);
      System.out.println("similarityScore: " + similarityScore);
    } catch (Exception e) {
      System.err.println("ERROR: " + e.getMessage());
    }
  }
}

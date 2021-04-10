package Day_01;

import org.openqa.selenium.WebElement;
import java.util.*;

public class Methods {

    public static void printThePopulation(List<WebElement> webElementList) {
        List<List<String>> rows = new ArrayList<>();
        List<String> headers = Arrays.asList( "    TODAY", "   THIS YEAR" );
        rows.add( headers );
        System.out.println( "  Current Population is => " + webElementList.get( 0 ).getText() );
        rows.add( Arrays.asList( "Births today", "Births this year" ) );
        rows.add( Arrays.asList( webElementList.get( 1 ).getText(), webElementList.get( 2 ).getText() ) );
        rows.add( Arrays.asList( "Deaths today", "Deaths this year" ) );
        rows.add( Arrays.asList( webElementList.get( 3 ).getText(), webElementList.get( 4 ).getText() ) );
        rows.add( Arrays.asList( "Population Growth today", "Population Growth this year" ) );
        rows.add( Arrays.asList( webElementList.get( 5 ).getText(), webElementList.get( 6 ).getText() ) );
        System.out.println( formatAsTable( rows ) );
    }


    public static String formatAsTable(List<List<String>> rows) {
        int[] maxLengths = new int[rows.get( 0 ).size()];
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                maxLengths[i] = Math.max( maxLengths[i], row.get( i ).length() );
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths) {
            formatBuilder.append( "%-" ).append( maxLength + 2 ).append( "s" );
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : rows) {
            result.append( String.format( format, row.toArray( new String[0] ) ) ).append( "\n" );
        }
        return result.toString();
    }

    public static void waiting(int howLong) {
        try {
            Thread.sleep( howLong );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

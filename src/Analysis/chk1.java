package Analysis;

import master.DbconnSemeval;
import static Semeval.SentimentProcess.ProcessComments.val;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class chk1 {

    public static double AmbTP = 0.0;
    public static double AmbFN = 0.0;
    public static double AmbFP = 0.0;
    public static double AmbTN = 0.0;

    public static double FoodTP = 0.0;
    public static double FoodFN = 0.0;
    public static double FoodFP = 0.0;
    public static double FoodTN = 0.0;

    public static double MiscTP = 0.0;
    public static double MiscFN = 0.0;
    public static double MiscFP = 0.0;
    public static double MiscTN = 0.0;

    public static double PriceTP = 0.0;
    public static double PriceFN = 0.0;
    public static double PriceFP = 0.0;
    public static double PriceTN = 0.0;

    public static double ServiceTP = 0.0;
    public static double ServiceFN = 0.0;
    public static double ServiceFP = 0.0;
    public static double ServiceTN = 0.0;

    public static int flag = 0;

    public static double TotalA = 0;
    public static double TotalB = 0;
    public static double TotalC = 0;
    public static double TotalD = 0;
    public static double TotalE = 0;
    public static double Total = 0;

    public static void main(String args[]) throws IOException {
        br();
    }

    public static void br() throws IOException {
        try {
            val = 1;
            DbconnSemeval db = new DbconnSemeval();
            Connection con = db.conn();
            Statement st = con.createStatement();
            st.executeQuery("select * from reviewtest");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                flag = 0;
                Total++;
                String Acutal = rs.getString("aspect").replaceAll("\\s+", "");
                String weightedaspect = "";
                if (val == 1) {
                    weightedaspect = rs.getString("tfaspect").replaceAll("\\s+", "");
                } else if (val == 2) {
                    weightedaspect = rs.getString("tfcoaspect").replaceAll("\\s+", "");
                } else if (val == 3) {
                    weightedaspect = rs.getString("weightedAspect").replaceAll("\\s+", "");
                } else if (val == 4) {
                    weightedaspect = rs.getString("weightedcoaspect").replaceAll("\\s+", "");
                } else {
                    weightedaspect = rs.getString("dpaspect").replaceAll("\\s+", "");
                }
                if (flag == 0 && Acutal.equalsIgnoreCase("ambiance")) {
                    TotalA++;
                    if (weightedaspect.equalsIgnoreCase("ambiance") && flag == 0) {
                        AmbTP = AmbTP + 1;
                        flag = 1;
                    } else if (flag == 0 && weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                        AmbFN = AmbFN + 1;
                        flag = 1;
                    }
                }

                //*****
                if (Acutal.equalsIgnoreCase("food") && flag == 0) {
                    TotalB++;
                    if (weightedaspect.equalsIgnoreCase("food") && flag == 0) {
                        FoodTP = FoodTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") && flag == 0) {
                        FoodFN = FoodFN + 1;
                        flag = 1;
                    }
                }
                //*****
                if (Acutal.equalsIgnoreCase("price") && flag == 0) {
                    TotalD++;
                    if (weightedaspect.equalsIgnoreCase("price") && flag == 0) {
                        PriceTP = PriceTP + 1;
                    } else if (flag == 0 && weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                        PriceFN = PriceFN + 1;
                        flag = 1;
                    }

                }
                //*****
                if (flag == 0 && Acutal.equalsIgnoreCase("miscellaneous") || Acutal.equalsIgnoreCase("anecdotes/miscellaneous")) {
                    TotalC++;
                    if (flag == 0 && weightedaspect.equalsIgnoreCase("miscellaneous") && flag == 0 || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                        MiscTP = MiscTP + 1;
                        flag = 1;
                    } else if (flag == 0 && weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("price")) {
                        MiscFN = MiscFN + 1;
                        flag = 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("service") && flag == 0) {
                    TotalE++;
                    if (weightedaspect.equalsIgnoreCase("service") && flag == 0) {
                        ServiceTP = ServiceTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambiance") && flag == 0 || weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                        ServiceFN = ServiceFN + 1;
                        flag = 1;
                    }

                }

                //***********************************************************************
                if (flag == 0 && Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("miscellaneous") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                    if (weightedaspect.equalsIgnoreCase("price") && flag == 0) {
                        PriceFP = PriceFP + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")) {
                    if (weightedaspect.equalsIgnoreCase("ambiance") && flag == 0) {
                        AmbFP = AmbFP + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")) {
                    if (weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") && flag == 0) {
                        MiscFP = MiscFP + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                    if (weightedaspect.equalsIgnoreCase("service") && flag == 0) {
                        ServiceFP = ServiceFP + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("service") || Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                    if (weightedaspect.equalsIgnoreCase("food") && flag == 0) {
                        FoodFP = FoodFP + 1;
                        flag = 1;
                    }

                }

                //*********************************************************************** TN
                if (flag == 0 && Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("miscellaneous") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                    if (!weightedaspect.equalsIgnoreCase("price") && flag == 0) {
                        PriceTN = PriceTN + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") || Acutal.equalsIgnoreCase("miscellaneous") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")) {
                    if (!weightedaspect.equalsIgnoreCase("ambiance") && flag == 0) {
                        AmbTN = AmbTN + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")) {
                    if (!weightedaspect.equalsIgnoreCase("miscellaneous") && flag == 0 || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                        MiscTN = MiscTN + 1;
                        flag = 1;
                    }

                }
                //****
                if (flag == 0 && Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                    if (!weightedaspect.equalsIgnoreCase("service") && flag == 0) {
                        ServiceTN = ServiceTN + 1;
                        flag = 1;
                    }
                }
                //****
                if (Acutal.equalsIgnoreCase("price") && flag == 0 || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") || Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("service") || Acutal.equalsIgnoreCase("miscellaneous")) {
                    if (!weightedaspect.equalsIgnoreCase("food")) {
                        FoodTN = FoodTN + 1;
                        flag = 1;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

     //   systemclass.Refresh(val);
        System.out.println("***************");
        System.out.println(AmbTP);
        System.out.println(AmbFN);
        System.out.println(AmbTN);
        System.out.println(AmbFP);
        System.out.println("***************");
        System.out.println(FoodTP);
        System.out.println(FoodFN);
        System.out.println(FoodTN);
        System.out.println(FoodFP);
        System.out.println("***************");
        System.out.println(ServiceTP);
        System.out.println(ServiceFN);
        System.out.println(ServiceTN);
        System.out.println(ServiceFP);
        System.out.println("***************");
        System.out.println(MiscTP);
        System.out.println(MiscFN);
        System.out.println(MiscTN);
        System.out.println(MiscFP);
        System.out.println("***************");
        System.out.println(PriceTP);
        System.out.println(PriceFN);
        System.out.println(PriceTN);
        System.out.println(PriceFP);
        System.out.println("***************");
        System.out.println(TotalA + "" + TotalB + "" + TotalC + "" + TotalD + "" + TotalE);
        System.out.println(Total);
    }

}

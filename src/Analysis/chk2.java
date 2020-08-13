package Analysis;

import static Yelp.SentimentProcess.ProcessComments.val;
import master.DbconnYelp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class chk2 {

    public static double AmbTP = 0.0;
    public static double AmbFN = 0.0;
    public static double AmbFP = 0.0;
    public static double AmbTN = 0.0;

    public static double FoodTP = 0.0;
    public static double FoodFN = 0.0;
    public static double FoodFP = 0.0;
    public static double FoodTN = 0.0;

    public static double PriceTP = 0.0;
    public static double PriceFN = 0.0;
    public static double PriceFP = 0.0;
    public static double PriceTN = 0.0;

    public static double ServiceTP = 0.0;
    public static double ServiceFN = 0.0;
    public static double ServiceFP = 0.0;
    public static double ServiceTN = 0.0;

    public static double RestTP = 0.0;
    public static double RestFN = 0.0;
    public static double RestFP = 0.0;
    public static double RestTN = 0.0;

    public static double wortTP = 0.0;
    public static double wortFN = 0.0;
    public static double wortFP = 0.0;
    public static double wortTN = 0.0;

    public static double TotalA = 0;
    public static double TotalB = 0;
    public static double TotalC = 0;
    public static double TotalD = 0;
    public static double TotalE = 0;
   public static double TotalF = 0;
    public static double flag = 0;

   
   
    public static void br() throws IOException {
        try {
            val=10;
            DbconnYelp db = new DbconnYelp();
            Connection con = db.conn();
            Statement st = con.createStatement();
            st.executeQuery("select * from reviewtest");
            ResultSet rs = st.getResultSet();
            
            while (rs.next()) {
            
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
                if (Acutal.equalsIgnoreCase("ambience")) {
                    TotalA = TotalA + 1;
                    if (weightedaspect.equalsIgnoreCase("ambience")) {
                        AmbTP = AmbTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("worthiness") || weightedaspect.equalsIgnoreCase("Restaurant")) {
                        AmbFN = AmbFN + 1;
                    }

                }

                //*****
                if (Acutal.equalsIgnoreCase("food")) {
                    TotalB = TotalB + 1;
                    if (weightedaspect.equalsIgnoreCase("food")) {
                        FoodTP = FoodTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambience") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("price") ||  weightedaspect.equalsIgnoreCase("worthiness") || weightedaspect.equalsIgnoreCase("Restaurant")) {
                        FoodFN = FoodFN + 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("price")) {
                    TotalD = TotalD + 1;
                    if (weightedaspect.equalsIgnoreCase("price")) {
                        PriceTP = PriceTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambience") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("food") ||  weightedaspect.equalsIgnoreCase("worthiness") || weightedaspect.equalsIgnoreCase("Restaurant")) {
                        PriceFN = PriceFN + 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("worthiness")) {
                    TotalC = TotalC + 1;
                    if (weightedaspect.equalsIgnoreCase("worthiness")) {
                        wortTP = wortTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambience") || weightedaspect.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("price")) {
                        wortFN = wortFN + 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("service")) {
                    TotalE = TotalE + 1;
                    if (weightedaspect.equalsIgnoreCase("service")) {
                        ServiceTP = ServiceTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambience") || weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) {
                        ServiceFN = ServiceFN + 1;
                    }

                }
    //*****
                if (Acutal.equalsIgnoreCase("Restaurant")) {
                    TotalF = TotalF + 1;
                    if (weightedaspect.equalsIgnoreCase("Restaurant")) {
                        RestTP = RestTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("ambience") || weightedaspect.equalsIgnoreCase("worthiness") || weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("service")) {
                       RestFN =RestFN+1;
                    }

                }
                //***********************************************************************
                if (Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("miscellaneous") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("worthiness")|| weightedaspect.equalsIgnoreCase("Restaurant")) {
                    if (weightedaspect.equalsIgnoreCase("price")) {
                        PriceFP = PriceFP + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("worthiness")|| weightedaspect.equalsIgnoreCase("Restaurant")|| Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")) {
                    if (weightedaspect.equalsIgnoreCase("ambience")) {
                        AmbFP = AmbFP + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")|| weightedaspect.equalsIgnoreCase("worthiness")) {
                    if (weightedaspect.equalsIgnoreCase("Restaurant")) {
                        RestFP = RestFP + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("worthiness") || weightedaspect.equalsIgnoreCase("Restaurant")) {
                    if (weightedaspect.equalsIgnoreCase("service")) {
                        ServiceFP = ServiceFP + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("service") || Acutal.equalsIgnoreCase("Restaurant") || weightedaspect.equalsIgnoreCase("worthiness")) {
                    if (weightedaspect.equalsIgnoreCase("food")) {
                        FoodFP = FoodFP + 1;
                    }
                    
                if (Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("service") || Acutal.equalsIgnoreCase("Restaurant") || weightedaspect.equalsIgnoreCase("food")) {
                    if (weightedaspect.equalsIgnoreCase("worthiness")) {
                        wortFP = wortFP + 1;
                    }

                }

                //*********************************************************************** TN
                if (Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("worthiness") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("restaurant")) {
                    if (!weightedaspect.equalsIgnoreCase("price")) {
                        PriceTN = PriceTN + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("worthiness") || Acutal.equalsIgnoreCase("restaurant") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")) {
                    if (!weightedaspect.equalsIgnoreCase("ambience")) {
                        AmbTN = AmbTN + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("service")|| Acutal.equalsIgnoreCase("Restaurant")) {
                    if (!weightedaspect.equalsIgnoreCase("worthinesss")) {
                        wortTN = wortTN + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("restaurant") || weightedaspect.equalsIgnoreCase("worthiness")) {
                    if (!weightedaspect.equalsIgnoreCase("service")) {
                        ServiceTN = ServiceTN + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("restaurant") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("service") || Acutal.equalsIgnoreCase("worthiness")) {
                    if (!weightedaspect.equalsIgnoreCase("food")) {
                        FoodTN = FoodTN + 1;
                    }
                    
                     if (Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("food") || Acutal.equalsIgnoreCase("ambience") || Acutal.equalsIgnoreCase("service") || Acutal.equalsIgnoreCase("worthiness")) {
                    if (!weightedaspect.equalsIgnoreCase("Restaurant")) {
                        RestTN = RestTN + 1;
                    }

                }

            }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

      //  systemclass.Refresh(val);
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
        System.out.println(wortTP);
        System.out.println(wortFN);
        System.out.println(wortTN);
        System.out.println(wortFP);
        System.out.println("***************");
        System.out.println(PriceTP);
        System.out.println(PriceFN);
        System.out.println(PriceTN);
        System.out.println(PriceFP);
        System.out.println("***************");
        System.out.println(RestTP);
        System.out.println(RestFN);
        System.out.println(RestTN);
        System.out.println(RestFP);
        System.out.println("***************");
         System.out.println(TotalA + "\t" + TotalB + "\t" + TotalC + "\t" + TotalD + "\t" + TotalE+ "\t" + TotalF);
    }

}

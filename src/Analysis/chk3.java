package Analysis;

import static Drug.SentimentProcess.ProcessComments.val;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import master.DbconnDrug;

public class chk3 {

    public static double BCTP = 0.0;
    public static double BCFN = 0.0;
    public static double BCFP = 0.0;
    public static double BCTN = 0.0;

    public static double DepTP = 0.0;
    public static double DepFN = 0.0;
    public static double DepFP = 0.0;
    public static double DepTN = 0.0;

    public static double BODTP = 0.0;
    public static double BODFN = 0.0;
    public static double BODFP = 0.0;
    public static double BODTN = 0.0;

    public static double PainTP = 0.0;
    public static double PainFN = 0.0;
    public static double PainFP = 0.0;
    public static double PainTN = 0.0;

    public static double WLTP = 0.0;
    public static double WLFN = 0.0;
    public static double WLFP = 0.0;
    public static double WLTN = 0.0;

    public static double TotalA = 0;
    public static double TotalB = 0;
    public static double TotalC = 0;
    public static double TotalD = 0;
    public static double TotalE = 0;

    public static void main(String args[]) throws IOException {
        br();
    }

    public static void br() throws IOException {
        try {
            val = 1;
            DbconnDrug db = new DbconnDrug();
            Connection con = db.conn();
            Statement st = con.createStatement();
            st.executeQuery("select * from reviewtest");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                String Acutal = rs.getString("aspect");
                String weightedaspect = "";
                if (val == 1) {
                    weightedaspect = rs.getString("tfaspect");
                } else if (val == 2) {
                    weightedaspect = rs.getString("tfcoaspect");
                } else if (val == 3) {
                    weightedaspect = rs.getString("weightedAspect");
                } else if (val == 4) {
                    weightedaspect = rs.getString("weightedcoaspect");
                } else {
                    weightedaspect = rs.getString("dpaspect");
                }
                if (Acutal.equalsIgnoreCase("Birth Control")) {
                    TotalA = TotalA + 1;
                    if (weightedaspect.equalsIgnoreCase("Birth Control")) {
                        BCTP = BCTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("pain") || weightedaspect.equalsIgnoreCase("Bipolar Disorde") || weightedaspect.equalsIgnoreCase("Depression") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        BCFN = BCFN + 1;
                    }

                }

                //*****
                if (Acutal.equalsIgnoreCase("pain")) {
                    TotalB = TotalB + 1;
                    if (weightedaspect.equalsIgnoreCase("pain")) {
                        PainTP = PainTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("Birth Control") || weightedaspect.equalsIgnoreCase("Bipolar Disorde") || weightedaspect.equalsIgnoreCase("Depression") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        PainFN = PainFN + 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("Depression")) {
                    TotalD = TotalD + 1;
                    if (weightedaspect.equalsIgnoreCase("Depression")) {
                        DepTP = DepTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("Birth Control") || weightedaspect.equalsIgnoreCase("Bipolar Disorde") || weightedaspect.equalsIgnoreCase("pain") || weightedaspect.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        DepFN = DepFN + 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("Weight Loss")) {
                    TotalC = TotalC + 1;
                    if (weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        WLTP = WLTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("Birth Control") || weightedaspect.equalsIgnoreCase("Bipolar Disorde") || weightedaspect.equalsIgnoreCase("pain") || weightedaspect.equalsIgnoreCase("Depression")) {
                        WLFN = WLFN + 1;
                    }

                }
                //*****
                if (Acutal.equalsIgnoreCase("Bipolar Disorde")) {
                    TotalE = TotalE + 1;
                    if (weightedaspect.equalsIgnoreCase("Bipolar Disorde")) {
                        BODTP = BODTP + 1;
                    } else if (weightedaspect.equalsIgnoreCase("Birth Control") || weightedaspect.equalsIgnoreCase("pain") || weightedaspect.equalsIgnoreCase("Depression") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        BODFN = BODFN + 1;
                    }

                }

                //***********************************************************************
                if (Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("Weight Loss") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Bipolar Disorde") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                    if (weightedaspect.equalsIgnoreCase("Depression")) {
                        DepFP = DepFP + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("Depression") || Acutal.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Bipolar Disorde")) {
                    if (weightedaspect.equalsIgnoreCase("Birth Control")) {
                        BCFP = BCFP + 1;
                    }

                }
                //****
                if (Acutal.equalsIgnoreCase("Depression") || Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Bipolar Disorde")) {
                    if (weightedaspect.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        WLFP = WLFP + 1;

                    }
                    //****
                    if (Acutal.equalsIgnoreCase("Depression") || Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        if (weightedaspect.equalsIgnoreCase("Bipolar Disorde")) {
                            BODFP = BODFP + 1;
                        }

                    }
                    //****
                    if (Acutal.equalsIgnoreCase("Depression") || Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("Bipolar Disorde") || Acutal.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        if (weightedaspect.equalsIgnoreCase("pain")) {
                            PainFP = PainFP + 1;
                        }

                    }

                    //*********************************************************************** TN
                    if (Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("Weight Loss") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Bipolar Disorde") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        if (!weightedaspect.equalsIgnoreCase("Depression")) {
                            DepTN = DepTN + 1;
                        }

                    }
                    //****
                    if (Acutal.equalsIgnoreCase("Depression") || weightedaspect.equalsIgnoreCase("Weight Loss") || Acutal.equalsIgnoreCase("Weight Loss") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Bipolar Disorde")) {
                        if (!weightedaspect.equalsIgnoreCase("Birth Control")) {
                            BCTN = BCTN + 1;
                        }

                    }
                    //****
                    if (Acutal.equalsIgnoreCase("Depression") || Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Bipolar Disorde")) {
                        if (!weightedaspect.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                            WLTN = WLTN + 1;
                        }

                    }
                    //****
                    if (Acutal.equalsIgnoreCase("Depression") || Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("pain") || Acutal.equalsIgnoreCase("Weight Loss") || weightedaspect.equalsIgnoreCase("Weight Loss")) {
                        if (!weightedaspect.equalsIgnoreCase("Bipolar Disorde")) {
                            BODTN = BODTN + 1;
                        }

                    }
                    //****
                    if (Acutal.equalsIgnoreCase("Depression") || weightedaspect.equalsIgnoreCase("Weight Loss") || Acutal.equalsIgnoreCase("Birth Control") || Acutal.equalsIgnoreCase("Bipolar Disorde") || Acutal.equalsIgnoreCase("Weight Loss")) {
                        if (!weightedaspect.equalsIgnoreCase("pain")) {
                            PainTN = PainTN + 1;
                        }

                    }

                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        systemclass.Refresh(val);
        System.out.println("***************");
        System.out.println(BCTP);
        System.out.println(BCFN);
        System.out.println(BCTN);
        System.out.println(BCFP);
        System.out.println("***************");
        System.out.println(PainTP);
        System.out.println(PainFN);
        System.out.println(PainTN);
        System.out.println(PainFP);
        System.out.println("***************");
        System.out.println(BODTP);
        System.out.println(BODFN);
        System.out.println(BODTN);
        System.out.println(BODFP);
        System.out.println("***************");
        System.out.println(DepTP);
        System.out.println(DepFN);
        System.out.println(DepTN);
        System.out.println(DepFP);
        System.out.println("***************");
        System.out.println(DepTP);
        System.out.println(DepFN);
        System.out.println(DepTN);
        System.out.println(DepFP);
        System.out.println("***************");
          System.out.println(TotalA + "\t" + TotalB + "\t" + TotalC + "\t" + TotalD + "\t" + TotalE);
    }

}

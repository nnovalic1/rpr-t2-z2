package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

   private double pocetnaTacka ;
   private double krajnjaTacka ;
   private boolean daLiPripadaPocetna ;
   private boolean daLiPripadaKrajnja ;


     Interval (double pocetna, double krajnja, boolean daLiPripadaPocetna , boolean daLiPripadaKrajnja ) {

         if ( pocetna > krajnja ) throw new IllegalArgumentException (" ") ;
         this.pocetnaTacka = pocetna ;
         this.krajnjaTacka = krajnja ;
         this.daLiPripadaPocetna = daLiPripadaPocetna ;
         this.daLiPripadaKrajnja = daLiPripadaKrajnja ;
     }

     Interval () {
         this.pocetnaTacka = 0 ;
         this.krajnjaTacka = 0 ;
         this.daLiPripadaKrajnja = false ;
         this.daLiPripadaPocetna = false ;
     }

     @Override
    public String toString () {

         if (daLiPripadaPocetna && daLiPripadaKrajnja)
             return "[" + pocetnaTacka + ","+ krajnjaTacka+"]";
         if (daLiPripadaPocetna && daLiPripadaKrajnja == false)
             return "[" + pocetnaTacka + ","+ krajnjaTacka+")";
         if (daLiPripadaPocetna == false && daLiPripadaKrajnja)
             return "(" + pocetnaTacka + ","+ krajnjaTacka+"]";
         if(pocetnaTacka == 0 && krajnjaTacka == 0 && daLiPripadaPocetna == false && daLiPripadaKrajnja==false)
             return "()" ;
         else
             return "(" + pocetnaTacka + ","+ krajnjaTacka+")";
     }


      boolean isNull () {

         if (this.pocetnaTacka == 0 && this.krajnjaTacka == 0 && !this.daLiPripadaPocetna && !this.daLiPripadaKrajnja ) return true ;
         return false ;
     }

      boolean isIn (double brojZaProvjeru) {

          if (brojZaProvjeru > pocetnaTacka && brojZaProvjeru < krajnjaTacka) return true ;
          if (brojZaProvjeru == pocetnaTacka && daLiPripadaPocetna) return true ;
          if (brojZaProvjeru == krajnjaTacka && daLiPripadaKrajnja) return true ;

          return false ;
      }

      @Override

    public boolean equals (Object o) {

          Interval pomocni = (Interval) o ;
          return pocetnaTacka == pomocni.pocetnaTacka && krajnjaTacka == pomocni.krajnjaTacka && daLiPripadaPocetna == pomocni.daLiPripadaPocetna  && daLiPripadaKrajnja == pomocni.daLiPripadaKrajnja ;
      }


      public Interval intersect (Interval interval ) {
         double donjaGranica , gornjaGranica ;
         boolean gornja, donja ;
        if (interval.pocetnaTacka > this.pocetnaTacka) {

            donjaGranica = interval.pocetnaTacka ;
            donja = interval.daLiPripadaPocetna ;
        }
        else  {

            donjaGranica = this.pocetnaTacka ;
            donja = this.daLiPripadaPocetna ;
        }
        if (interval.krajnjaTacka < this.krajnjaTacka) {

            gornjaGranica = interval.krajnjaTacka ;
            gornja = interval.daLiPripadaKrajnja ;
        }
        else {

            gornjaGranica = this.krajnjaTacka ;
            gornja = this.daLiPripadaKrajnja ;
        }

        return new Interval(donjaGranica,gornjaGranica,donja,gornja) ;
    }


       public static Interval intersect (Interval intervalJedan, Interval intervalDva) {

           double donjaGranica , gornjaGranica ;
           boolean donja, gornja ;
           if (intervalJedan.pocetnaTacka > intervalDva.pocetnaTacka) {

               donjaGranica = intervalJedan.pocetnaTacka;
               donja = intervalJedan.daLiPripadaPocetna ;
           }
           else {

               donjaGranica = intervalDva.pocetnaTacka ;
               donja =  intervalDva.daLiPripadaPocetna ;
           }

           if (intervalJedan.krajnjaTacka < intervalDva.krajnjaTacka) {

               gornjaGranica = intervalJedan.krajnjaTacka ;
               gornja = intervalJedan.daLiPripadaKrajnja ;

           }
           else  {

               gornjaGranica = intervalDva.krajnjaTacka ;
               gornja = intervalDva.daLiPripadaKrajnja ;
           }

           return new Interval(donjaGranica,gornjaGranica,donja,gornja) ;
       }
}

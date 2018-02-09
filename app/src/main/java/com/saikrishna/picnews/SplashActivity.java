package com.saikrishna.picnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    MyApplication myapp;

    int num;
    int num2;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        num = items.length;
        num2 = fontnames.length;

        myapp = MyApplication.getInstance();

        new Thread(new Runnable() {
            public void run() {
                all();
            }
        }).start();
    }

    String[] items = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","tweleve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen"
    ,"nineteen","twnety","twentyone","twentytwo","twentythree","twentyfour","twentyfive","twentysix"};

    String[] fontnames = {"Adamas-Regular.otf", "AirbagFree-Regular.ttf", "Anders.ttf", "Ansley Display-Inline.ttf", "ArgonPERSONAL-Regular.otf", "BEYNO.ttf"
            , "DistractorFree-Regular.otf", "FAIL____.TTF", "FARRAY.otf", "Humblle Rought Caps.ttf", "Kamilitza DEMO.ttf", "Lombok.otf", "Lovelo Line Bold.otf"
            , "Lovelo Line Light.otf", "Metropolis 1920.otf", "Monthoers.ttf", "NikolaidisHand.ttf", "plstk.ttf", "REIS-Regular.ttf", "Rex Bold Inline.otf", "Shumi.otf"
            , "SonderSans-BlackRough.otf", "Timber.ttf", "TrueLove-bold.ttf", "TrueLove.ttf"};

    void all() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,1);
                    new Thread(new Runnable() {
                        public void run() {
                            entertainment();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void entertainment() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/entertainment").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,2);
                    new Thread(new Runnable() {
                        public void run() {
                            sports();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void sports() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/sports").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,3);
                    new Thread(new Runnable() {
                        public void run() {
                            money();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void money() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/money").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,4);
                    new Thread(new Runnable() {
                        public void run() {
                            lifestyle();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void lifestyle() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/lifestyle").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,5);
                    new Thread(new Runnable() {
                        public void run() {
                            health();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void health() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/health").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,6);
                    new Thread(new Runnable() {
                        public void run() {
                            travel();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void travel() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/travel").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,7);
                    new Thread(new Runnable() {
                        public void run() {
                            food();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void food() {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.youtube.com/feeds/videos.xml?channel_id=UCJFp8uSYCjXOMnkUyb3CQ3Q").get();

            String str = doc.toString();
            String[] arrClone = str.split("<entry>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k = 1; k < arrClone.length; k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link rel=\"alternate\" href=\"") + 28);
                tempInside = tempInside.substring(0, tempInside.indexOf("\" /> "));
                temp = temp + "#http://img.youtube.com/vi/" + tempInside.trim().substring(tempInside.trim().indexOf("watch?v=") + 8) + "/maxresdefault.jpg#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,8);
                    new Thread(new Runnable() {
                        public void run() {
                            autos();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void autos() {
        Document doc;
        try {
            doc = Jsoup.connect("http://rss.msn.com/en-in/autos").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k=1;k<arrClone.length;k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                if (tempInside.contains("src=")) {
                    tempInside = tempInside.substring(tempInside.indexOf(" src=") + 6);
                    tempInside = tempInside.substring(0, tempInside.indexOf("h=100"));
                    temp = temp + "#" + tempInside.trim();
                } else {
                    temp = temp + "#" + "0";
                }
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<link>") + 6);
                tempInside = tempInside.substring(0, tempInside.indexOf("</link>"));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,9);
                    new Thread(new Runnable() {
                        public void run() {
                            videos();
                        }
                    }).start();
                }
            });

        } catch (IOException e) {

        }
    }

    void videos() {
        Document doc;
        try {
            doc = Jsoup.connect("http://feeds.feedburner.com/devourfeed").get();

            String str = doc.toString();
            String[] arrClone = str.split("<item>");

            String temp = null;

            final List<String> arr = new ArrayList<String>();

            String tempInside;

            for (Integer k = 1; k < arrClone.length; k++) {
                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf("<title>") + 7);
                tempInside = tempInside.substring(0, tempInside.indexOf("</title>"));
                temp = tempInside.trim();

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf(";img src=") + 10);
                tempInside = tempInside.substring(0, tempInside.indexOf("\" alt="));
                temp = temp + "#" + tempInside.trim();

                tempInside = arrClone[k];
                tempInside = tempInside.substring(tempInside.indexOf(";a href=\"") + 9);
                tempInside = tempInside.substring(0, tempInside.indexOf("\" rel=\"bookmark\""));
                temp = temp + "#" + tempInside.trim();

                arr.add(temp + "#" + items[r.nextInt(num - 0)] + "#" + fontnames[r.nextInt(num2 - 0)]);
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    myapp.setArray(arr,10);
                    SplashActivity.this.finish();
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            });

        } catch (IOException e) {

        }
    }
}

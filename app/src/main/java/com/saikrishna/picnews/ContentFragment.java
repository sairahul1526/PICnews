package com.saikrishna.picnews;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.GridHolder;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.squareup.picasso.Picasso;

public class ContentFragment extends Fragment {

    DatabaseHelper myDb;

    public ContentFragment() {
    }

    static String titl = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.myDb = new DatabaseHelper(getContext());

        titl = getArguments().getString("scanContent");

        if (titl.split("#")[3].matches("one")) {
            View view = inflater.inflate(R.layout.one, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView8);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("two")) {
            View view = inflater.inflate(R.layout.two, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView5);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView6);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("three")) {
            View view = inflater.inflate(R.layout.three, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView7);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("four")) {
            View view = inflater.inflate(R.layout.four, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView8);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("five")) {
            View view = inflater.inflate(R.layout.five, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView9);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView8);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("six")) {
            View view = inflater.inflate(R.layout.six, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView7);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("seven")) {
            View view = inflater.inflate(R.layout.seven, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("eight")) {
            View view = inflater.inflate(R.layout.eight, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button2);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("nine")) {
            View view = inflater.inflate(R.layout.nine, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("ten")) {
            View view = inflater.inflate(R.layout.ten, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button3);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("eleven")) {
            View view = inflater.inflate(R.layout.eleven, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.imageView3);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("tweleve")) {
            View view = inflater.inflate(R.layout.tweleve, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button4);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("thirteen")) {
            View view = inflater.inflate(R.layout.thirteen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button5);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final CircularImageView imageView7 = (CircularImageView) view.findViewById(R.id.imageView4);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("fourteen")) {
            View view = inflater.inflate(R.layout.fourteen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.textView7);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("fifteen")) {
            View view = inflater.inflate(R.layout.fifteen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button2);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("sixteen")) {
            View view = inflater.inflate(R.layout.sixteen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("seventeen")) {
            View view = inflater.inflate(R.layout.seventeen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("eighteen")) {
            View view = inflater.inflate(R.layout.eighteen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("nineteen")) {
            View view = inflater.inflate(R.layout.nineteen, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button6);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("twnety")) {
            View view = inflater.inflate(R.layout.twnety, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button7);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView7);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("twentyone")) {
            View view = inflater.inflate(R.layout.twentyone, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button8);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final CircularImageView imageView7 = (CircularImageView) view.findViewById(R.id.imageView4);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("twentytwo")) {
            View view = inflater.inflate(R.layout.twentytwo, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.imageView9);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView5);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("twentythree")) {
            View view = inflater.inflate(R.layout.twentythree, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button9);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView10);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("twentyfour")) {
            View view = inflater.inflate(R.layout.twentyfour, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button10);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView4);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else if (titl.split("#")[3].matches("twentyfive")) {
            View view = inflater.inflate(R.layout.twentyfive, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button7);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView12);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        } else {
            View view = inflater.inflate(R.layout.twentysix, container, false);

            TextView button6 = (TextView) view.findViewById(R.id.button7);
            button6.setText("\n\n" + titl.split("#")[0] + "\n\n");

            Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "font/" + titl.split("#")[4]);
            button6.setTypeface(face);

            final ImageView imageView7 = (ImageView) view.findViewById(R.id.imageView12);

            Picasso.with(getContext()).load(titl.split("#")[1]).into(imageView7);

            final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setTag(titl);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String val1 = String.valueOf(fab.getTag());
                    Boolean wheBool = false;
                    if (isThere(val1) == true) {
                        wheBool = true;
                    }
                    DialogPlus dialog = DialogPlus.newDialog(getActivity())
                            .setContentHolder(new GridHolder(3))
                            .setCancelable(true)
                            .setAdapter(new SimpleAdapter(getActivity(), wheBool))
                            .setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                    String val = String.valueOf(fab.getTag());
                                    if (position==0) {
                                        if (isThere(val) == false) {
                                            boolean isInserted = myDb.insertData(val);
                                            Toast.makeText(getContext(),"SAVED",Toast.LENGTH_LONG).show();
                                        } else {
                                            myDb.deleteData(val);
                                            Toast.makeText(getContext(),"REMOVED",Toast.LENGTH_LONG).show();
                                        }
                                    } else if (position==1) {
                                        Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                                        share1.setType("text/plain");
                                        share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                                        share1.putExtra(Intent.EXTRA_TEXT, val.split("#")[0] + "\n\n" + val.split("#")[2] + "\n\n-via PICnews");

                                        getActivity().startActivity(Intent.createChooser(share1, "Share link!"));
                                    } else {
                                        Intent myIntent = new Intent(getContext(), Main2Activity.class);
                                        myIntent.putExtra("key", val);
                                        getContext().startActivity(myIntent);
                                    }
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            });

            return view;
        }
    }

    public String getTitle() {
        return getArguments().getString("title");
    }

    public Boolean isThere(String val) {
        Cursor res = myDb.getAllData();
        Boolean sent = false;
        if(res.getCount() == 0) {
        } else {
            while (res.moveToNext()) {
                if(res.getString(0).contains(val.split("#")[0])) {
                    sent = true;
                    Log.d("sairahul", "yes treu");
                    break;
                }
            }
        }
        return sent;
    }
}

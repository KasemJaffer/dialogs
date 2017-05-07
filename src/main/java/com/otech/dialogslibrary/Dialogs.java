package com.otech.dialogslibrary;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;



/**
 * TODO: Add a class header comment!
 */
public class Dialogs {

    public static void showShortToast(final Activity context, final String message) {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showLongtToast(final Activity context, final String message) {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });

    }

    public static ProgressDialog getProgressDialog(Activity context,
                                                   String message, boolean cancelable) {
        ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage(message);
        pDialog.setCanceledOnTouchOutside(cancelable);
        pDialog.setCancelable(cancelable);
        return pDialog;
    }

    public static ProgressDialog getDeterminateProgressDialog(Activity context,
                                                              String message, boolean cancelable) {
        ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage(message);
        pDialog.setCanceledOnTouchOutside(cancelable);
        pDialog.setCancelable(cancelable);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        return pDialog;
    }

    public static void showProgressDialogWithList(
            Activity context,
            String title,
            String[] list,
            boolean cancelable,
            DialogInterface.OnClickListener listener) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setItems(list, listener);

        AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        alertDialog.show();
    }

    public static void showProgressDialogWithList(
            Activity context,
            String title,
            String[] list,
            int selectedPosition,
            boolean cancelable,
            DialogInterface.OnClickListener listener) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setSingleChoiceItems(list, selectedPosition, listener);

        AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        alertDialog.show();
    }

    public static AlertDialog showProgressDialogWithOneNumberPicker(
            Activity context,
            String title,
            String message,
            NumberPicker number1,
            boolean cancelable,
            String okText,
            String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(8, 8, 8, 8);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);


        params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 4, 0, 0);

        number1.setLayoutParams(params);


        layout.addView(number1);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setView(layout);
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (okMethod != null)
                    okMethod.run();
            }
        });
        // set negative button: No message
        alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (cancelMethod != null)
                    cancelMethod.run();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        // show alert
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showProgressDialogWithTwoNumberPicker(
            Activity context,
            String title,
            String message,
            NumberPicker number1,
            NumberPicker number2,
            boolean cancelable,
            String okText,
            String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);


        params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        number1.setLayoutParams(params);

        params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        int padding = dpToPixels(context, 20.0f);
        params.setMargins(padding, 0, 0, 0);
        number2.setLayoutParams(params);

        layout.addView(number1);
        layout.addView(number2);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setView(layout);
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (okMethod != null)
                    okMethod.run();
            }
        });
        // set negative button: No message
        alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (cancelMethod != null)
                    cancelMethod.run();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        // show alert
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showProgressDialogWithEditText(
            Activity context,
            String title,
            String message,
            EditText edit,
            boolean cancelable,
            String okText,
            String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod,
            final int featureDrawableResource,
            final int color) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);

        int padding = dpToPixels(context, 16.0f);
        int padding2 = dpToPixels(context, 20.0f);
        layout.setPadding(padding2, padding, padding2, 0);

        TextInputLayout lay = new TextInputLayout(context);
        lay.setLayoutParams(params);
        edit.setLayoutParams(params);

        lay.addView(edit);
        layout.addView(lay);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setView(layout);
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

//                if (okMethod != null)
//                    okMethod.run();
            }
        });
        // set negative button: No message
        if (cancelText != null)
            alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

//                    if (cancelMethod != null)
//                        cancelMethod.run();
                }
            });

        final AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        Drawable drawable = ContextCompat.getDrawable(context, featureDrawableResource);
        if (drawable != null && color != -1) {
            drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        }
        alertDialog.setIcon(drawable);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {

                Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (okMethod != null)
                            okMethod.run();
                    }
                });

                Button b2 = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                if (b2 != null)
                    b2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if (cancelMethod != null)
                                cancelMethod.run();
                        }
                    });
            }
        });
        // show alert
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showProgressDialogTwoWithEditText(
            Activity context,
            String title,
            String message,
            EditText edit1,
            EditText edit2,
            boolean cancelable,
            String okText,
            String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod,
            final int featureDrawableResource,
            final int color) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);

        int padding = dpToPixels(context, 16.0f);
        int padding2 = dpToPixels(context, 20.0f);
        layout.setPadding(padding2, padding, padding2, 0);

        TextInputLayout lay1 = new TextInputLayout(context);
        lay1.setLayoutParams(params);
        edit1.setLayoutParams(params);

        lay1.addView(edit1);
        layout.addView(lay1);

        TextInputLayout lay2 = new TextInputLayout(context);
        lay2.setLayoutParams(params);
        edit2.setLayoutParams(params);

        lay2.addView(edit2);
        layout.addView(lay2);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setView(layout);
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

//                if (okMethod != null)
//                    okMethod.run();
            }
        });
        // set negative button: No message
        if (cancelText != null)
            alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

//                    if (cancelMethod != null)
//                        cancelMethod.run();
                }
            });

        final AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        Drawable drawable = ContextCompat.getDrawable(context, featureDrawableResource);
        if (drawable != null && color != -1) {
            drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        }
        alertDialog.setIcon(drawable);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {

                Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (okMethod != null)
                            okMethod.run();
                    }
                });

                Button b2 = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                if (b2 != null)
                    b2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if (cancelMethod != null)
                                cancelMethod.run();
                        }
                    });
            }
        });
        // show alert
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showProgressDialogWithEditText(
            Activity context,
            String title,
            String message,
            EditText edit,
            boolean cancelable,
            String okText,
            String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);

        int padding = dpToPixels(context, 16.0f);
        int padding2 = dpToPixels(context, 20.0f);
        layout.setPadding(padding2, padding, padding2, 0);

        TextInputLayout lay = new TextInputLayout(context);
        lay.setLayoutParams(params);
        edit.setLayoutParams(params);

        lay.addView(edit);
        layout.addView(lay);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setView(layout);
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

//                if (okMethod != null)
//                    okMethod.run();
            }
        });
        // set negative button: No message
        if (cancelText != null)
            alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

//                    if (cancelMethod != null)
//                        cancelMethod.run();
                }
            });

        final AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {

                Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (okMethod != null)
                            okMethod.run();
                    }
                });

                Button b2 = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                if (b2 != null)
                    b2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if (cancelMethod != null)
                                cancelMethod.run();
                        }
                    });
            }
        });
        // show alert
        alertDialog.show();
        return alertDialog;
    }

    public static void showProgressDialogWithTwoButtons(
            final Activity context,
            final String title,
            final String message,
            final boolean cancelable,
            final String okText,
            final String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod) {

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle(title);
                alertDialogBuilder.setMessage(message);
                // set positive button: Yes message
                alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (okMethod != null)
                            okMethod.run();
                    }
                });
                // set negative button: No message
                alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (cancelMethod != null)
                            cancelMethod.run();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
                // show alert
                alertDialog.show();
            }
        });

    }

    public static void showProgressDialogWithTwoButtons(
            final Activity context,
            final String title,
            final String message,
            final boolean cancelable,
            final String okText,
            final String cancelText,
            final Runnable okMethod,
            final Runnable cancelMethod,
            final int featureDrawableResource,
            final int color) {

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle(title);
                alertDialogBuilder.setMessage(message);
                // set positive button: Yes message
                alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (okMethod != null)
                            okMethod.run();
                    }
                });
                // set negative button: No message
                alertDialogBuilder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (cancelMethod != null)
                            cancelMethod.run();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
                Drawable drawable = ContextCompat.getDrawable(context, featureDrawableResource);
                if (drawable != null && color != -1) {
                    drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
                }
                alertDialog.setIcon(drawable);
                alertDialog.show();
            }
        });

    }

    public static void showProgressDialogWithOneButton(
            final Activity context,
            final String title,
            final String message,
            final boolean cancelable,
            final String okText,
            final Runnable okMethod,
            final int featureDrawableResource,
            final int color) {

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle(title);
                alertDialogBuilder.setMessage(message);

                // set positive button: Yes message
                alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (okMethod != null)
                            okMethod.run();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();

                Drawable drawable = ContextCompat.getDrawable(context, featureDrawableResource);
                if (drawable != null && color != -1) {
                    drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
                }

                alertDialog.setIcon(drawable);
                // show alert
                alertDialog.show();
            }
        });

    }

    public static void showProgressDialog(
            final Activity context,
            final String title,
            final String message,
            final int featureDrawableResource,
            final int color) {

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle(title);
                alertDialogBuilder.setMessage(message);


                AlertDialog alertDialog = alertDialogBuilder.setCancelable(true).create();

                Drawable drawable = ContextCompat.getDrawable(context, featureDrawableResource);
                if (drawable != null && color != -1) {
                    drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
                }

                alertDialog.setIcon(drawable);
                // show alert
                alertDialog.show();
            }
        });

    }

    public static void showProgressDialogWithOneButton(
            final Activity context,
            final String title,
            final String message,
            final boolean cancelable,
            final String okText,
            final Runnable okMethod) {

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle(title);
                alertDialogBuilder.setMessage(message);

                // set positive button: Yes message
                alertDialogBuilder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (okMethod != null)
                            okMethod.run();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.setCancelable(cancelable).create();
                // show alert
                alertDialog.show();
            }
        });
    }

    private static int dpToPixels(Context context, float GESTURE_THRESHOLD_DP) {
        // Get the screen's density scale
        final float scale = context.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);
    }
}

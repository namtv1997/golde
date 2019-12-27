package com.app.goldenhealth.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.DividerItemDecoration;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import com.app.goldenhealth.App;
import com.app.goldenhealth.Key;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Toolbox {

    static final String TAG = "Toolbox";

    private static Gson defaultGson;
    private static String DEVICE_UUID;
    public static final int SECOND_MILLIS = 1000;
    public static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    public static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    public static final int DAY_MILLIS = 24 * HOUR_MILLIS;


    public static Long getCurrentMillis() {
        return System.currentTimeMillis() / 1000;
    }

    public static Date getDatefromMillisLong(Long s) {
        if (s == null) return null;
        Timestamp stamp = new Timestamp(s * 1000);
        Date date = new Date(stamp.getTime());
        return date;
    }

    public static String parseDateVN(String time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "hh:mm dd/MM/yyyy ";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateVN2(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd/MM/yyyy ";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDateVNNotime(String time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "dd/MM/yyyy ";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static String getDatefromMillis(Long s) {
        return getDatefromMillisLong(s) + "";
    }

    public static Date addMonth(Date start, int added) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.MONTH, added);
        return c.getTime();
    }

    public static void hideKeyboard(EditText e) {
        InputMethodManager imm = (InputMethodManager) App.getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(e.getWindowToken(), 0);
    }

    public static Date addDay(Date start, int added) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, added);
        return c.getTime();
    }

    public static int getMonth(Date start) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        return c.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Date start) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        return c.get(Calendar.YEAR);
    }

    public static Integer differenceInMonths(Date beginningDate, Date endingDate) {
        if (beginningDate == null || endingDate == null) {
            return 0;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(beginningDate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endingDate);
        return differenceInMonths(cal1, cal2);
    }

    private static Integer differenceInMonths(Calendar beginningDate, Calendar endingDate) {
        if (beginningDate == null || endingDate == null) {
            return 0;
        }
        int m1 = beginningDate.get(Calendar.YEAR) * 12 + beginningDate.get(Calendar.MONTH);
        int m2 = endingDate.get(Calendar.YEAR) * 12 + endingDate.get(Calendar.MONTH);
        return m2 - m1;
    }


    public static boolean isLocationServicesTurnOn(Context context) {
        boolean gps_enabled, network_enabled;

        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        return gps_enabled || network_enabled;
    }

    public static void startSharingIntent(Context context, String textToShare) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
        context.startActivity(sharingIntent);
    }


    public static boolean isEmpty(CharSequence str) {
        return str == null || TextUtils.getTrimmedLength(str) == 0 || "null".equalsIgnoreCase(str.toString().trim());
    }


    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    public static void toggleVisibility(View v) {
        v.setVisibility(v.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static int randomInt(int min, int max) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ThreadLocalRandom.current().nextInt(min, max + 1);
        }

        int range = max - min + 1;
        double rand = Math.random() * range;
        return (int) (min + rand);
    }

    public static long randomLong(long min, long max) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ThreadLocalRandom.current().nextLong(min, max + 1);
        }

        long range = max - min + 1;
        double rand = Math.random() * range;
        return (long) (min + rand);
    }

    public static double randomDouble(double min, double max) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ThreadLocalRandom.current().nextDouble(min, max);
        }

        double range = max - min;
        return Math.random() * range + min;
    }


    public static RoundedBitmapDrawable getRoundedDrawable(Resources resources, Bitmap bitmap) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(resources, bitmap);
        roundedBitmapDrawable.setCircular(true);
        roundedBitmapDrawable.setAntiAlias(true);
        return roundedBitmapDrawable;
    }

    public static DividerItemDecoration simpleDividerItemDecoration(Context context, int orientation, float dpSize, @ColorInt int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpSize, context.getResources().getDisplayMetrics());
        gradientDrawable.setSize(size, size);
        gradientDrawable.setColor(color);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, orientation);
        dividerItemDecoration.setDrawable(gradientDrawable);

        return dividerItemDecoration;
    }


    public static DatePickerDialog showDatePickerDialog(Context context, @Nullable Date min, @Nullable Date max, OnDateSetListener listener) {
        return showDatePickerDialog(context, min == null ? -1 : min.getTime(), max == null ? -1 : max.getTime(), listener);
    }

    public static DatePickerDialog showDatePickerDialog(Context context, Calendar focusDay, @Nullable Date min, @Nullable Date max, OnDateSetListener listener) {
        return showDatePickerDialog(context, focusDay, min == null ? -1 : min.getTime(), max == null ? -1 : max.getTime(), listener);
    }

    public static DatePickerDialog showDatePickerDialog(Context context, Date focusDay, @Nullable Date min, @Nullable Date max, OnDateSetListener listener) {
        Calendar current = Calendar.getInstance();
        current.setTime(focusDay);
        return showDatePickerDialog(context, current, min == null ? -1 : min.getTime(), max == null ? -1 : max.getTime(), listener);
    }

    public static DatePickerDialog showDatePickerDialog(Context context, long min, long max, OnDateSetListener listener) {
        return showDatePickerDialog(context, Calendar.getInstance(), min, max, listener);
    }

    public static DatePickerDialog showDatePickerDialog(Context context, Calendar focusDay, long min, long max, final OnDateSetListener listener) {
        int year = focusDay.get(Calendar.YEAR);
        int month = focusDay.get(Calendar.MONTH);
        int dayOfMonth = focusDay.get(Calendar.DAY_OF_MONTH);
        int theme;
        if (Build.VERSION.SDK_INT < 23) {
            theme = AlertDialog.THEME_HOLO_LIGHT;
        } else theme = android.R.style.Theme_Holo_Light_Dialog;
        DatePickerDialog dialog = new DatePickerDialog(context, theme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                listener.onDateSet(year, month, dayOfMonth, c);
            }
        }, year, month, dayOfMonth);
        if (min != -1) dialog.getDatePicker().setMinDate(min);
        if (max != -1) dialog.getDatePicker().setMaxDate(max);
        dialog.show();
        return dialog;
    }

    public static void selectDate(Context context, @Nullable Date min, @Nullable Date max, final EditText editText){
        showDatePickerDialog(context, min, max, new OnDateSetListener() {
            @Override
            public void onDateSet(int year, int month, int dayOfMonth, Calendar calendar) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String datee = dateFormat.format(calendar.getTime());
                editText.setText(datee);
            }
        });
    }

    public static void selectDate(Context context, @Nullable Date min, @Nullable Date max, final TextView textView){
        showDatePickerDialog(context, min, max, new OnDateSetListener() {
            @Override
            public void onDateSet(int year, int month, int dayOfMonth, Calendar calendar) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String datee = dateFormat.format(calendar.getTime());
                textView.setText(datee);
            }
        });
    }

    public static void selectDate(Context context, @Nullable Date min, @Nullable Date max, final TextView textView, final OnDateSetListener listener){
        showDatePickerDialog(context, min, max, new OnDateSetListener() {
            @Override
            public void onDateSet(int year, int month, int dayOfMonth, Calendar calendar) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String datee = dateFormat.format(calendar.getTime());
                textView.setText(datee);

                listener.onDateSet(year, month + 1, dayOfMonth, calendar);
            }
        });
    }

    public static DatePickerDialog showDatePickerMonthYearDialog(Context context, @Nullable Date min, @Nullable Date max, OnDateSetListener listener) {
        return showDatePickerMonthYearDialog(context, min == null ? -1 : min.getTime(), max == null ? -1 : max.getTime(), listener);
    }

    public static DatePickerDialog showDatePickerMonthYearDialog(Context context, long min, long max, OnDateSetListener listener) {
        return showDatePickerMonthYearDialog(context, Calendar.getInstance(), min, max, listener);
    }

    public static DatePickerDialog showDatePickerMonthYearDialog(Context context, Calendar focusDay, long min, long max, final OnDateSetListener listener){
        int year = focusDay.get(Calendar.YEAR);
        int month = focusDay.get(Calendar.MONTH);
        int dayOfMonth = focusDay.get(Calendar.DAY_OF_MONTH);
        int theme;
        if (Build.VERSION.SDK_INT < 23) {
            theme = AlertDialog.THEME_HOLO_LIGHT;
        } else theme = android.R.style.Theme_Holo_Light_Dialog;
        DatePickerDialog mDatePickerDialog = new DatePickerDialog(context, theme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, i);
                c.set(Calendar.MONTH, i1);
                c.set(Calendar.DAY_OF_MONTH, i2);

                listener.onDateSet(i, i1, i2, c);
            }
        }, year, month, dayOfMonth);

        try {
            Field[] datePickerDialogFields = mDatePickerDialog.getClass().getDeclaredFields();
            for (Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker =
                            (DatePicker) datePickerDialogField.get(mDatePickerDialog);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        int daySpinnerId =
                                Resources.getSystem().getIdentifier("day", "id", "android");
                        if (daySpinnerId != 0) {
                            View daySpinner = datePicker.findViewById(daySpinnerId);
                            if (daySpinner != null) {
                                //Ẩn cột date, chỉ còn lại month và year
                                daySpinner.setVisibility(View.GONE);
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException: ", e);
        }
        if (min != -1) mDatePickerDialog.getDatePicker().setMinDate(min);
        if (max != -1) mDatePickerDialog.getDatePicker().setMaxDate(max);

        mDatePickerDialog.show();
        return mDatePickerDialog;
    }

    public static String formatNumber(int number) {
        return DecimalFormat.getNumberInstance(Key.LOCALE_VN).format(number) + " đ";
    }

    public static String formatNumber(long number) {
        return DecimalFormat.getNumberInstance(Key.LOCALE_VN).format(number) + " đ";
    }

    public static String formatNumberNotD(int number) {
        Locale localeVn = new Locale("vi", "VN");
        return DecimalFormat.getNumberInstance(Key.LOCALE_VN).format(number);
    }

    public static Bitmap screenshot(View v) {
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache(true);

        Bitmap b = Bitmap.createBitmap(v.getDrawingCache());

        v.setDrawingCacheEnabled(false);
        return b;

    }

    public static void saveBitmapToImg(Bitmap bitmap) {
        if (bitmap == null) return;
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/req_images");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "myqrcode-itro.jpg";
        File file = new File(myDir, fname);
        Log.i(TAG, "" + file);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

            ApplicationContextSingleton.getInstance().getApplicationContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }

    public static String getTimeAgo(Context context, long start, long end) {
        if (start < 1000000000000L) {
            start *= 1000;
        }
        if (end < 1000000000000L) {
            end *= 1000;
        }

        long now = System.currentTimeMillis();
        if (start > end || start <= 0) {
            return null;
        }


        final long diff = end - start;
        if (diff < MINUTE_MILLIS) {
            return diff / SECOND_MILLIS + " giây";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "1 phút";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " phút";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "một giờ";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " giờ";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "1 ngày";
        } else {
            return diff / DAY_MILLIS + " ngày";
        }
    }

    public static String convertToTimeAgo(Long time) {
        CharSequence ago = DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS);
        return ago.toString();
    }

    public interface OnDateSetListener {
        void onDateSet(int year, int month, int dayOfMonth, Calendar calendar);
    }


}

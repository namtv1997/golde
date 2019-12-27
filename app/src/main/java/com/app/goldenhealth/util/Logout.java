package com.app.goldenhealth.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.ui.activity.LoginActivity;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;

import static com.app.goldenhealth.ui.fragment.Login2Fragment.mGoogleSignInClient;

public class Logout {

    private Logout() {

    }

    public static void logout(final Context context) {
        Log.i("SettingFragment", "logout: ");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Đăng xuất");
        builder.setMessage("Bạn phải đăng nhập lại!");
        builder.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialogInterface, int i) {
//                onClickLogout(context);


                ZaloSDK.Instance.unauthenticate();
                LoginManager.getInstance().logOut();
                PrefUtil.delete(context, Key.APP_PREFERENCE);
                context.startActivity(LoginActivity.getCallingIntent(context));
                dialogInterface.dismiss();
//                mGoogleSignInClient.signOut()
//                        .addOnCompleteListener((AppCompatActivity) context, new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                PrefUtil.delete(context, Key.APP_PREFERENCE);
//                                context.startActivity(LoginActivity.getCallingIntent(context));
//                                dialogInterface.dismiss();
//                            }
//                        });
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void onClickLogout(Context context) {

//        Util.getIns().showLoadding(context);
//        String token = "Bearer " + PrefUtil.getDataUser(context).getToken();
//        NetworkModule.getService().logout(token, "android")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<JsonObject>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Util.getIns().hideLoadding();
//                        Log.i("SettingFragment", "onError: " + e);
//                        String username = PrefUtil.getString(context, Key.USER_NAME, "");
//                        PrefUtil.delete(context, Key.APP_PREFERENCE);
//                        PrefUtil.delete(context, Key.FILTER);
//                        PrefUtil.saveString(context, Key.USER_NAME, username);
//                        PrefUtil.saveInt(context, Key.IS_FIRST_TIME, 1);
//                        Intent intent = new Intent(context, LoginActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        context.startActivity(intent);
//                        ((Activity) context).finish();
//                    }
//
//                    @Override
//                    public void onNext(JsonObject jsonObject) {
//                        Util.getIns().hideLoadding();
//                        Log.i("SettingFragment", "onNext: " + jsonObject);
//                        String username = PrefUtil.getString(context, Key.USER_NAME, "");
//                        PrefUtil.delete(context, Key.APP_PREFERENCE);
//                        PrefUtil.delete(context, Key.FILTER);
//                        PrefUtil.saveString(context, Key.USER_NAME, username);
//                        PrefUtil.saveInt(context, Key.IS_FIRST_TIME, 1);
//                        Intent intent = new Intent(context, LoginActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        context.startActivity(intent);
//                        ((Activity) context).finish();
//                    }
//                });
    }
}

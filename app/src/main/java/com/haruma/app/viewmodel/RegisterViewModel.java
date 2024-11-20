package com.haruma.app.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.haruma.app.BR;
import com.haruma.app.model.Callback;
import com.haruma.app.model.User;

import java.util.Map;
import java.util.Objects;

public class RegisterViewModel extends BaseObservable {

    private String email;

    private String password;

    private final Context context;

    private final Map<String, Callback> callback;

    public RegisterViewModel(Context context, Map<String, Callback> callback) {
        this.context = context;
        this.callback = callback;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    private void makeToast(String message) {
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show();
    }

    public void onLogin() {
        try {
            Objects.requireNonNull(this.callback.get("onLogin")).run();
        } catch (Exception e) {
            makeToast("Lỗi xảy ra: " + e.getMessage());
        }
    }

    public void onRegister() {
        try {
            User user = new User(this.getEmail(), this.getPassword());
            if (user.getEmail() != null && !user.getEmail().isEmpty()) {
                makeToast("Đăng ký thành công");
                Objects.requireNonNull(this.callback.get("onRegister")).run();
            }
            else {
                makeToast("Đăng ký thất bại");
            }
        } catch (Exception e) {
            makeToast("Lỗi xảy ra: " + e.getMessage());
        }
    }

}

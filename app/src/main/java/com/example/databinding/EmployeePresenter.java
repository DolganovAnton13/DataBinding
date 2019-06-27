package com.example.databinding;

import android.content.ContentValues;

import android.text.TextUtils;
import android.view.View;

public class EmployeePresenter {
    private MainActivity _view;

    public void attachView(MainActivity usersActivity) {
        _view = usersActivity;
    }

    public void detachView() {
        _view = null;
    }

    public void add(View view) {
        Employee employee = _view.getEmployee();
        Department department = _view.getDepartment();
        if (TextUtils.isEmpty(employee.name) || TextUtils.isEmpty(employee.address)) {
            _view.showToast(R.string.empty_values);
            return;
        }

        _view.setData(employee,department);
    }

    public void clear(View view) {
        Employee employee = _view.getEmployee();
        Department department = _view.getDepartment();
        employee.address="no data";
        employee.name="no data";
        department.name="no data";

        _view.setData(employee,department);
    }
}

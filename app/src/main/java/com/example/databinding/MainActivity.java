package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private EmployeePresenter presenter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

    }

    private void init() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new EmployeePresenter();
        presenter.attachView(this);

        Employee employee = new Employee(1,"no data","no data",0);
        Department department = new Department(1,"no data");
        setData(employee,department);
        binding.setEmployeePresenter(presenter);
    }

    public Employee getEmployee() {
        Employee employee = new Employee(1,binding.setName.getText().toString(),binding.setAddress.getText().toString(),100);
        return employee;
    }

    public Department getDepartment() {
        Department department = new Department(1,"IT");
        return department;
    }

    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    public void setData(Employee employee,Department department) {
        binding.setEmployee(employee);
        binding.setDepartment(department);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}

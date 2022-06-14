package com.example.thiwcd.model;

import com.example.thiwcd.constant.SqlConstant;
import com.example.thiwcd.entity.Phone;
import com.example.thiwcd.service.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class MySqlPhoneModel implements PhoneModel {

    @Override
    public boolean save(Phone obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.PHONE_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getBrand());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Phone> findAll() {
        return null;
    }
}

package com.hugeardor.vidit.gupshup.Common;

import com.hugeardor.vidit.gupshup.Holder.QBUsersHolder;
import com.quickblox.users.model.QBUser;

import java.util.List;

/**
 * Created by vidit on 12/6/17.
 */

public class Common {

    public static String createChatDialogName (List<Integer> qbUsers)
    {
        List<QBUser> qbUsers1 = QBUsersHolder.getInstance().getUsersByIds(qbUsers);
        StringBuilder name = new StringBuilder();
        for(QBUser user : qbUsers1)
        {
            name.append(user.getFullName()).append(" ");


        }
        if(name.length()>30)
        {
            name=name.replace(30, name.length()-1 , "...");

        }
        return name.toString();


    }



}




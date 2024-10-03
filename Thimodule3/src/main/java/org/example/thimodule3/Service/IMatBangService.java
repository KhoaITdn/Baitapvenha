package org.example.thimodule3.Service;
import org.example.thimodule3.Model.MatBang;

import java.util.List;

public interface IMatBangService {
    List<MatBang> findAll();

        void deleteMatBang(String maMb);

    void addMatBang(MatBang matBang);

    boolean getMatBangByMaMb(String maMb);

//    void addMatBang(MatBang matBang);
//
//    void deleteMatBang(String maMb);
//

}
package apap.tutorial.haidokter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.haidokter.model.RoleModel;
import apap.tutorial.haidokter.repository.RoleDb;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDb roleDb;

    @Override
    public List<RoleModel> findAll(){
        return roleDb.findAll();
    }
}

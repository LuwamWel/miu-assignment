package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.Userr;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepoImpl implements UserRepo {
    private static List<Userr> users = new ArrayList<>();
    private final ModelMapper modelMapper;

    public UserRepoImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Userr> findAll() {
        return users;
    }

    @Override
    public Userr findById(long id) {
        return users.stream()
                .filter(usr -> usr.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Userr usr) {
        users.add(usr);
    }

    @Override
    public void delete(long id) {
        users.removeIf(usr -> usr.getId() == id);
    }

    @Override
    public List<Post> findPostByUserId(long id) {
        Userr usr = findById(id);
        return usr.getPosts();
    }


}

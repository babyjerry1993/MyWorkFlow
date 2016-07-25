package sy.dao;

import org.springframework.stereotype.Repository;

import sy.model.Post;

@Repository(value = "postMapper")
public interface PostMapper {
    int deleteByPrimaryKey(Integer postid);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}
import React, { PropTypes } from 'react';
import Post from './Post';

const Posts = (props) =>
  <ul>
    {props.posts.map((post, i) =>
      <Post key={i} post={post} />
    )}
  </ul>;

Posts.propTypes = {
  posts: PropTypes.array.isRequired,
};

export default Posts;

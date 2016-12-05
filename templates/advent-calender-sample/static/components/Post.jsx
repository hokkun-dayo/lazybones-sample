import React, { PropTypes } from 'react';
import { FormattedRelative } from 'react-intl';

const Post = (props) =>
  <div>
    <h5>{props.post.title}</h5>
    <FormattedRelative value={new Date(props.post.created_utc * 1000)} />
  </div>;

Post.propTypes = {
  post: PropTypes.shape(
    {
      title: PropTypes.string.isRequired,
      created_utc: PropTypes.number.isRequired,
    }
  ).isRequired,
};

export default Post;

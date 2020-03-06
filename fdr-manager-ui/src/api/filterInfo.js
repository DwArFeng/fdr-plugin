import {
  del, get, patch, post,
} from '../util/http';

export function exists(key) {
  return get('/filter-info/exists', {
    key,
  });
}

export function inspect(key) {
  return get('/filter-info', {
    key,
  });
}

export function insert(pointkey, enabled, remark, content, type) {
  return post('/filter-info', {
    key: null,
    pointKey: {
      long_id: pointkey,
    },
    enabled,
    remark,
    content,
    type,
  });
}

export function remove(key) {
  return del('/filter-info', {
    key,
  });
}

export function update(key, pointkey, enabled, remark, content, type) {
  return patch('/filter-info', {
    key: {
      long_id: key,
    },
    pointKey: {
      long_id: pointkey,
    },
    enabled,
    remark,
    content,
    type,
  });
}

export function all(page, rows) {
  return get('/filter-info/all', {
    page,
    rows,
  });
}

export function childForPoint(key, page, rows) {
  return get('/filter-info/child-for-point', {
    key,
    page,
    rows,
  });
}

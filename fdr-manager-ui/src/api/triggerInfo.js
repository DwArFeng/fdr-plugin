import {
  del, get, patch, post,
} from '../util/http';

export function exists(key) {
  return get('/trigger-info/exists', {
    key,
  });
}

export function inspect(key) {
  return get('/trigger-info', {
    key,
  });
}

export function insert(pointkey, enabled, remark, content, type) {
  return post('/trigger-info', {
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
  return del('/trigger-info', {
    key,
  });
}

export function update(key, pointkey, enabled, remark, content, type) {
  return patch('/trigger-info', {
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
  return get('/trigger-info/all', {
    page,
    rows,
  });
}

export function childForPoint(key, page, rows) {
  return get('/trigger-info/child-for-point', {
    key,
    page,
    rows,
  });
}

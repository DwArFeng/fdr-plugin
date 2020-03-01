import {
  del, get, patch, post,
} from '../util/http';

export function exists(key) {
  return get('/point/exists', {
    key,
  });
}

export function inspect(key) {
  return get('/point', {
    key,
  });
}

export function insert(name, remark, realtimeEnabled, persistenceEnabled) {
  return post('/point', {
    key: null,
    remark,
    name,
    persistence_enabled: persistenceEnabled,
    realtime_enabled: realtimeEnabled,
  });
}

export function remove(key) {
  return del('/point', {
    key,
  });
}

export function update(key, name, remark, realtimeEnabled, persistenceEnabled) {
  return patch('/point', {
    key: {
      long_id: key,
    },
    remark,
    name,
    persistence_enabled: persistenceEnabled,
    realtime_enabled: realtimeEnabled,
  });
}

export function all(page, rows) {
  return get('/point/all', {
    page,
    rows,
  });
}

export function nameLike(name, page, rows) {
  return get('/point/name-like', {
    name,
    page,
    rows,
  });
}

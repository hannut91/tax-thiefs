import React from 'react';

import './App.css';

import { RenderAfterNavermapsLoaded, NaverMap } from 'react-naver-maps';

function App() {
  return (
    <div className="App">
      <RenderAfterNavermapsLoaded
        ncpClientId={'qiq4esm1zw'}
        error={<p>Maps Load Error</p>}
        loading={<p>Maps Loading...</p>}
      >
        <NaverMap
          mapDivId={'map'}
          style={{
            width: '100%',
            height: '100%',
          }}
          defaultCenter={{ lat: 37.3595704, lng: 127.105399 }}
          defaultZoom={10}
        />
      </RenderAfterNavermapsLoaded>
    </div>
  );
}

export default App;

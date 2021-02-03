class CSS {
  static set(element, styles) {
    for (let key in styles) element.style[key] = styles[key];
  }
}

export default CSS;

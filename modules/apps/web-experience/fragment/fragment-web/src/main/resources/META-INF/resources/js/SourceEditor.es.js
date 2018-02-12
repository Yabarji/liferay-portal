import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import AceEditor from './AceEditor.es';
import templates from './SourceEditor.soy';

/**
 * Component that creates an instance of Ace editor
 * to allow code editing.
 */
class SourceEditor extends Component {
	/**
	 * Callback executed when the internal Ace editor has been
	 * modified. It simply propagates the event.
	 * @param {Event} event
	 */
	_handleContentChanged(event) {
		this.emit(
			'contentChanged',
			{
				content: event.content
			}
		);
	}
}

/**
 * State definition.
 * @type {!Object}
 * @static
 */
SourceEditor.STATE = {
	/**
	 * Initial content sent to the editor
	 * @instance
	 * @memberOf SourceEditor
	 * @type {!string}
	 */
	initialContent: Config.string().required(),

	/**
	 * Syntax used for the editor.
	 * It will be used for Ace and rendered on the interface.
	 * @instance
	 * @memberOf SourceEditor
	 * @see AceEditor.SYNTAX
	 * @type {!string}
	 */
	syntax: Config.oneOf(Object.values(AceEditor.SYNTAX)).required(),
};

Soy.register(SourceEditor, templates);

export {SourceEditor};
export default SourceEditor;